package com.sfac.springcloud.springCloudClientAccount.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.sfac.springcloud.springCloudClientAccount.modules.account.Service.UserService;
import com.sfac.springcloud.springCloudClientAccount.modules.account.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * author  Jayoung
 * createDate  2020/8/20 0020 9:05
 * version 1.0
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 127.0.0.1/api/user/2   ---- get
     */
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable int userId) {
        return userService.getUserByUserId(userId);
    }

}
