package com.sfac.javaSpringBoot.modules.account.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/21
 * Time: 14:23
 * Description: No Description
 */
@Repository
@Mapper
public interface UserRoleDao {

    @Delete("delete from user_role where user_id = #{userId}")
    void deleteUserRoleByUserId(int userId);

    @Insert("insert into user_role (user_id,role_id)" +
            " values (#{userId},#{roleId})")
    void insertUserRole(int userId,int roleId);

}
