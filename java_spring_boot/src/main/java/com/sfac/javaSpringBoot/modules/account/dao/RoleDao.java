package com.sfac.javaSpringBoot.modules.account.dao;

import com.sfac.javaSpringBoot.modules.account.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/21
 * Time: 14:48
 * Description: No Description
 */
@Repository
@Mapper
public interface RoleDao {

    @Select("select * from role r " +
            "left join user_role ur on r.role_id = ur.role_id " +
            "where ur.user_id = #{userId}")
    List<Role> getRoleByUserId(int userId);

    @Select("select * from role")
    List<Role> getRoles();

}
