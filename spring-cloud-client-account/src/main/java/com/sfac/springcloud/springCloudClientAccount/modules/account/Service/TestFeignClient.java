package com.sfac.springcloud.springCloudClientAccount.modules.account.Service;

import com.sfac.springcloud.springCloudClientAccount.modules.account.Service.Impl.TestFeignClientFallback;
import com.sfac.springcloud.springCloudClientAccount.modules.account.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/28
 * Time: 16:28
 * Description: No Description
 */
@FeignClient(value = "CLIENT-TEST",fallback = TestFeignClientFallback.class)
@Primary
public interface TestFeignClient {

    @GetMapping("/api/cities/{countryId}")
    List<City> getCitiesByCountryId(@PathVariable int countryId);
}
