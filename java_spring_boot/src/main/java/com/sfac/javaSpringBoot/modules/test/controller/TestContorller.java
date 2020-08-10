package com.sfac.javaSpringBoot.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/10
 * Time: 14:03
 * Description: No Description
 */
@Controller
@RequestMapping("/test")
public class TestContorller {
    /**
     * 127.0.0.1:8080/test/testDesc----get
     * @return
     */
    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(){
        return "this is test module desc";
    }
}
