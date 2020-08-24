package com.sfac.javaSpringBoot.modules.account.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sfac.javaSpringBoot.config.ResourceConfigBean;
import com.sfac.javaSpringBoot.modules.account.dao.UserDao;
import com.sfac.javaSpringBoot.modules.account.dao.UserRoleDao;
import com.sfac.javaSpringBoot.modules.account.entity.Role;
import com.sfac.javaSpringBoot.modules.account.entity.User;
import com.sfac.javaSpringBoot.modules.account.service.UserService;
import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import com.sfac.javaSpringBoot.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
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
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private ResourceConfigBean resourceConfigBean;


    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        User userTemp =userDao.getUserByUserName(user.getUserName());
        if(userTemp!=null){
            return new Result<User>(
                    Result.ResultStatus.FAILD.status,"User name is repeat.");
        }


        user.setCreateDate(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userDao.insertUser(user);

        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles =user.getRoles();
        if (roles!=null && !roles.isEmpty()){
            //与下面写法一样的功能
            /*for (Role role : roles) {
                userRoleDao.insertUserRole(user.getUserId(),role.getRoleId());
            }*/
            roles.stream().forEach(item->{
                userRoleDao.insertUserRole(user.getUserId(),item.getRoleId());
            });
        }

        return new  Result<User>(
                Result.ResultStatus.SUCCESS.status,"Insert success",user);
    }

    @Override
    @Transactional
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
    @Transactional
    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<User>(Optional.ofNullable(userDao.getUsersBySearchVo(searchVo))
                .orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<User> updateUser(User user) {
        User userTemp =userDao.getUserByUserName(user.getUserName());
        if(userTemp!=null && userTemp.getUserId() != user.getUserId()){
            return new Result<User>(
                    Result.ResultStatus.FAILD.status,"User name is repeat.");
        }

        userDao.updateUser(user);

        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles =user.getRoles();
        if (roles!=null && !roles.isEmpty()){
            //与下面写法一样的功能
            /*for (Role role : roles) {
                userRoleDao.insertUserRole(user.getUserId(),role.getRoleId());
            }*/
            roles.stream().forEach(item->{
                userRoleDao.insertUserRole(user.getUserId(),item.getRoleId());
            });
        }


        return new Result<User>(Result.ResultStatus.SUCCESS.status,
                "Update Success.",user);
    }

    @Override
    @Transactional
    public Result<Object> deleteUser(int userId) {
        userDao.deleteUser(userId);
        userRoleDao.deleteUserRoleByUserId(userId);
        return new Result<Object>(Result.ResultStatus.SUCCESS.status,"Delete sucess");
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public Result<String> uploadUserImg(MultipartFile file) {
        if (file.isEmpty()) {
            return new Result<String>(Result.ResultStatus.FAILD.status,"Please select img");
        }
        String relativePath="";
        //绝对路径+文件名
        String destFilePath = "";
        try {
            String osName =System.getProperty("os.name");
            if (osName.toLowerCase().startsWith("win")){
                destFilePath=resourceConfigBean.getLocationPathForWindows()
                        +file.getOriginalFilename();
            }else {
                destFilePath=resourceConfigBean.getLocationPathForLinux()
                        +file.getOriginalFilename();
            }
            //相对路径
            relativePath=resourceConfigBean.getRelativePath()
                    +file.getOriginalFilename();
            //目标文件destFile
            File destFile = new File(destFilePath);
            //迁移到某个地方
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
           return new Result<String>(Result.ResultStatus.FAILD.status,"Upload  failed.");
        }
        return new Result<String>(
                Result.ResultStatus.SUCCESS.status,"Upload  success.",relativePath);
    }

    @Override
    @Transactional
    public Result<User> updateUserProfile(User user) {
        User userTemp = userDao.getUserByUserName(user.getUserName());
        if (userTemp != null && userTemp.getUserId() != user.getUserId()) {
            return new Result<User>(Result.ResultStatus.FAILD.status, "User name is repeat.");
        }

        userDao.updateUser(user);

        return new Result<User>(Result.ResultStatus.SUCCESS.status, "Edit success.", user);
    }

}
