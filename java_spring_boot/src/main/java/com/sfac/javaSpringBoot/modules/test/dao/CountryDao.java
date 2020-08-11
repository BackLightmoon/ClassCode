package com.sfac.javaSpringBoot.modules.test.dao;

import com.sfac.javaSpringBoot.modules.test.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/11
 * Time: 18:38
 * Description: No Description
 */
@Repository
@Mapper
public interface CountryDao {

    @Select("select * from m_country where country_id = #{countryId}")
    @Results(id = "countryResults",value = {
            @Result(column = "country_id",property = "countryId"),
            @Result(column = "country_id",property = "cities",
                    javaType = List.class,
                    many = @Many(select = "com.sfac.javaSpringBoot.modules.test.dao.CityDao.getCitiesByCountryId"))
    })
    Country getCounryByCountryId(int countryId);

    @Select("select * from m_country where country_name = #{countryName}")
    @ResultMap(value = "countryResults")
    Country getCountryByCountryName(String countryName);
}
