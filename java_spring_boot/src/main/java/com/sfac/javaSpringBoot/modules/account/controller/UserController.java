package com.sfac.javaSpringBoot.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.sfac.javaSpringBoot.modules.account.entity.User;
import com.sfac.javaSpringBoot.modules.account.service.UserService;
import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/20
 * Time: 9:07
 * Description: No Description
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 127.0.0.1/api/user -----post
     * {"userName":"admin","password":"111111"}
     * @param user
     * @return
     */
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    /**
     * 127.0.0.1/api/login ------post
     * {"userName":"admin","password":"111111"}
     * @param user
     * @return
     */
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 127.0.0.1/api/users -----post
     * {"currentPage":"1","pageSize":"5","keyWord":"hu"}
     * @param searchVo
     * @return
     */
    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<User> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
        return userService.getUsersBySearchVo(searchVo);
    }

    /**
     * 127.0.0.1/api/user  ------put
     * {"userName":"hujiang1","userImg":"/aaa.jpg","userId":"7"}
     * @param user
     * @return
     */
    @PutMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     *127.0.0.1/api/user/1   -------delete
     * @param userId
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public Result<Object> deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }


    /**
     * 127.0.0.1/api/user/2  --------get
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable int userId) {
        return userService.getUserByUserId(userId);
    }

}