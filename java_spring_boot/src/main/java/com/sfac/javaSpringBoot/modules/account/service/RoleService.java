package com.sfac.javaSpringBoot.modules.account.service;

import com.sfac.javaSpringBoot.modules.account.entity.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/22
 * Time: 15:02
 * Description: No Description
 */
public interface RoleService {

    List<Role> getRoles();

}
