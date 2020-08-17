package com.sfac.javaSpringBoot.modules.test.controller;

import com.sfac.javaSpringBoot.modules.test.entity.Country;
import com.sfac.javaSpringBoot.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/11
 * Time: 18:49
 * Description: No Description
 */
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * 127.0.0.1/api/country/522  ------get
     * @param countryId
     * @return
     */
    @GetMapping("/country/{countryId}")
    public Country getCounryByCountryId(@PathVariable int countryId){
        return countryService.getCountryByCountryId(countryId);
    }

    /**
     * 127.0.0.1/api/country?countryName=China  -----get
     */
    @GetMapping("/country")
    public  Country getCountryByCountryName(@RequestParam String countryName){
        return countryService.getCountryByCountryName(countryName);
    }

    /**
     *127.0.0.1/api/redis/country/522 -----get
     */
    @GetMapping("/redis/country/{countryId}")
    public Country mograteCountryByRedis(@PathVariable int countryId) {
        return countryService.mograteCountryByRedis(countryId);
    }
}
