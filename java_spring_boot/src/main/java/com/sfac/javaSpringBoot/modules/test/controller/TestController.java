package com.sfac.javaSpringBoot.modules.test.controller;

import com.sfac.javaSpringBoot.modules.test.entity.City;
import com.sfac.javaSpringBoot.modules.test.entity.Country;
import com.sfac.javaSpringBoot.modules.test.service.CityService;
import com.sfac.javaSpringBoot.modules.test.service.CountryService;
import com.sfac.javaSpringBoot.modules.test.vo.ApplicationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/10
 * Time: 14:03
 * Description: No Description
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port}")
    private int port;
    @Value("${com.name}")
    private String name;
    @Value("${com.age}")
    private int age;
    @Value("${com.desc}")
    private String desc;
    @Value("${com.random}")
    private String random;

    @Autowired
    private ApplicationTest applicationTest;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    /**
     * 127.0.0.1/test/file -----post
     * @param file
     * @param redirectAttributes
     * @return
     * 接收类型：multipart/form-data，和前端一样
     */
    @PostMapping(value = "/file", consumes = "multipart/form-data")
    public String uploadFile(@RequestParam MultipartFile file,
                             RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "message", "Please select file.");
            return "redirect:/test/index";
        }


        try {
            //路径+文件名
            String destFilePath = "D:\\Java\\IdeaProjects\\ProjectCode\\upload\\" + file.getOriginalFilename();
            //目标文件destFile
            File destFile = new File(destFilePath);
            //迁移到某个地方
            file.transferTo(destFile);
            // 使用工具类Files来上传文件
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(destFileName);
//			Files.write(path, bytes);
            redirectAttributes.addFlashAttribute(
                    "message", "Upload file success.");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute(
                    "message", "Upload file failed.");
        }

        return "redirect:/test/index";
    }

    @PostMapping(value = "/files",consumes = "multipart/form-data")
    public String uploadFiles(@RequestParam MultipartFile[] files,
                              RedirectAttributes redirectAttributes){
        //标识
        boolean empty=true;
            try {
                for (MultipartFile file :files) {
                    if (file.isEmpty()){
                        //为空。进入下一次循环
                        continue;
                    }
                    String destFilePath = "D:\\Java\\IdeaProjects\\ProjectCode\\upload\\" + file.getOriginalFilename();
                    File destFile = new File(destFilePath);
                    file.transferTo(destFile);
                    empty=false;
                }
                if (empty){
                    redirectAttributes.addFlashAttribute(
                            "message", "Please select file.");
                }else {
                    redirectAttributes.addFlashAttribute(
                            "message", "Upload file success.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute(
                        "message", "Upload file failed.");
            }

        return "redirect:/test/index";
    }

    /**
     * 127.0.0.1/test/file ------get
     * @param fileName
     * @return
     */
    @GetMapping("/file")
    public ResponseEntity downloadFile(@RequestParam String fileName){

        String aa = null;
        Resource resource=null;
        try {
           resource= new UrlResource(
                    Paths.get("D:\\Java\\IdeaProjects\\ProjectCode\\upload\\"+fileName).toUri());
           if(resource.exists()&&resource.isReadable()){
               aa=new String(fileName.getBytes("utf-8"),"ISO-8859-1");
           }
            /**
             * CONTENT_TYPE，包装好的常量，可以替代Content-Type
             * CONTENT_DISPOSITION对于下载的描述
             * attachment：以附件的形式存在的
             * filename：下载的内容的名称
             */
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE,"application/octet-stream")
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            String.format("attachment;filename=\"%s\"",aa))
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 127.0.0.1/test/index
     * @return
     */
    @GetMapping("/index")
    public String testIndexPage(ModelMap modelMap) {
        int countryId = 522;
        List<City> cities = cityService.getCitiesByCountryId(countryId);
        cities = cities.stream().limit(10).collect(Collectors.toList());
        Country country = countryService.getCountryByCountryId(countryId);

        modelMap.addAttribute("thymeleafTitle", "scdscsadcsacd");
        modelMap.addAttribute("checked", true);
        modelMap.addAttribute("currentNumber", 99);
        modelMap.addAttribute("changeType", "checkbox");
        modelMap.addAttribute("baiduUrl", "/test/log");
        modelMap.addAttribute("city", cities.get(0));
        modelMap.addAttribute("shopLogo",
                "http://cdn.duitang.com/uploads/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
        modelMap.addAttribute("shopLogo",
                "/upload/1111.png");
        modelMap.addAttribute("country", country);
        modelMap.addAttribute("cities", cities);
        modelMap.addAttribute("updateCityUri", "/api/city");
        //modelMap.addAttribute("template", "test/index");
        // 返回外层的碎片组装器
        return "index";
    }


    /**
     * 127.0.0.1/test/index2
     */
    @GetMapping("/index2")
    public String testIndex2Page(ModelMap modelMap) {
        modelMap.addAttribute("template", "test/index2");
        return "index";
    }

    /**
     * 127.0.0.1:8085/test/logTest ---- get
     */
    @GetMapping("/logTest")
    @ResponseBody
    public String logTest() {
        LOGGER.trace("This is trace log");
        LOGGER.debug("This is debug log");
        LOGGER.info("This is info log");
        LOGGER.warn("This is warn log");
        LOGGER.error("This is error log");
        return "This is log test11111111";
    }

    /**
     * 127.0.0.1:8085/test/config-----get
     * @return
     */
    @GetMapping("/config")
    @ResponseBody
    public String configTest() {
        StringBuffer sb = new StringBuffer();
        sb.append(port).append("----")
                .append(name).append("----")
                .append(age).append("----")
                .append(desc).append("----")
                .append(random).append("----").append("<br>");
        sb.append(applicationTest.getPort()).append("----")
                .append(applicationTest.getName()).append("----")
                .append(applicationTest.getAge()).append("----")
                .append(applicationTest.getDesc()).append("----")
                .append(applicationTest.getRandom()).append("----").append("<br>");

        return sb.toString();

    }
    /**
     * 127.0.0.1/test/testDesc?paramKey=fuck----get
     * @return
     */
    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(HttpServletRequest request,
                           @RequestParam(value = "paramKey") String paramValue){
        String paramValue2  =request.getParameter("paramKey");
        return "this is test module desc......" +paramValue +"===" + paramValue2;
    }
}
