package com.sfac.javaSpringBoot.modules.test.service.Impl;

import com.sfac.javaSpringBoot.config.RedisConfig;
import com.sfac.javaSpringBoot.modules.test.dao.CountryDao;
import com.sfac.javaSpringBoot.modules.test.entity.Country;
import com.sfac.javaSpringBoot.modules.test.service.CountryService;
import com.sfac.javaSpringBoot.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/11
 * Time: 18:45
 * Description: No Description
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Country getCountryByCountryId(int countryId) {
        return countryDao.getCounryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return countryDao.getCountryByCountryName(countryName);
    }

    @Override
    public Country mograteCountryByRedis(int countryId) {
        Country country=countryDao.getCounryByCountryId(countryId);

        String countryKey = String.format("country%d",countryId);
        redisUtils.set(countryKey,country);
        return (Country) redisUtils.get(countryKey);
    }
}
