package com.sfac.javaSpringBoot.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.sfac.javaSpringBoot.modules.account.entity.User;
import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/20
 * Time: 9:02
 * Description: No Description
 */
public interface UserService {

    Result<User> insertUser(User user);

    Result<User> login(User user);

    PageInfo<User> getUsersBySearchVo(SearchVo searchVo);
}
