package com.sfac.javaSpringBoot.modules.test.controller;

import com.github.pagehelper.PageInfo;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import com.sfac.javaSpringBoot.modules.test.entity.City;
import com.sfac.javaSpringBoot.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/11
 * Time: 19:15
 * Description: No Description
 */
@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 127.0.0.1/api/cities/522  ------get
     * @param countryId
     * @return
     */
    @GetMapping("/cities/{countryId}")
    public  List<City> getCitiesByCountryId(@PathVariable int countryId){
        return cityService.getCitiesByCountryId(countryId);
    }

    /**
     * 127.0.0.1/api/cities/522 ----post
     * {"currentPage":"1","pageSize":"5"}
     * @param countryId
     * @param searchVo
     * @return
     */
    @PostMapping(value = "/cities/{countryId}",consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@PathVariable int countryId,@RequestBody SearchVo searchVo) {
     return cityService.getCitiesBySearchVo(countryId,searchVo);
    }

}
