package com.sfac.javaSpringBoot.modules.account.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.javaSpringBoot.modules.account.dao.UserDao;
import com.sfac.javaSpringBoot.modules.account.entity.User;
import com.sfac.javaSpringBoot.modules.account.service.UserService;
import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import com.sfac.javaSpringBoot.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/20
 * Time: 9:02
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<User> insertUser(User user) {
        User userTemp =userDao.getUserByUserName(user.getUserName());
        if(userTemp!=null){
            return new Result<User>(
                    Result.ResultStatus.FAILD.status,"User name is repeat.");
        }

        user.setCreateDate(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userDao.insertUser(user);
        return new  Result<User>(
                Result.ResultStatus.SUCCESS.status,"Insert success",user);
    }

    @Override
    public Result<User> login(User user) {
        User userTemp =userDao.getUserByUserName(user.getUserName());
        if(userTemp!=null &&
                userTemp.getPassword().equals(MD5Util.getMD5(user.getPassword()))){
            return new Result<User>(Result.ResultStatus.SUCCESS.status,
                    "Success.",userTemp);
        }
        return new Result<User>(Result.ResultStatus.FAILD.status,
                "UserName or password is error.");
    }

    @Override
    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<User>(Optional.ofNullable(userDao.getUsersBySearchVo(searchVo))
                .orElse(Collections.emptyList()));
    }

}
