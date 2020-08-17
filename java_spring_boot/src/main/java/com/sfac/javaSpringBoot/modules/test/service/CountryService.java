package com.sfac.javaSpringBoot.modules.test.service;

import com.sfac.javaSpringBoot.modules.test.entity.Country;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/11
 * Time: 18:44
 * Description: No Description
 */
public interface CountryService {

    Country getCountryByCountryId(int countryId);
    Country getCountryByCountryName(String countryName);

    Country mograteCountryByRedis(int countryId);
}
