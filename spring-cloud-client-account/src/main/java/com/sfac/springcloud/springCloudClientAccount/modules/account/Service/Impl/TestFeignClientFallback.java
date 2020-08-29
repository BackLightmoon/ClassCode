package com.sfac.springcloud.springCloudClientAccount.modules.account.Service.Impl;

import com.sfac.springcloud.springCloudClientAccount.modules.account.Service.TestFeignClient;
import com.sfac.springcloud.springCloudClientAccount.modules.account.entity.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/29
 * Time: 10:34
 * Description: No Description
 */
@Component
public class TestFeignClientFallback implements TestFeignClient {

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return new ArrayList<>();
    }
}
