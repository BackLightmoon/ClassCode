package com.sfac.javaSpringBoot.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/17
 * Time: 16:25
 * Description: No Description
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 127.0.0.1/account/users -----get
     * @return
     */
    @GetMapping("/users")
    public String usersPage(){
        return "index";
    }

    /**
     * 127.0.0.1/account/login  -----get
     * @return
     */
    @GetMapping("/login")
    public String loginPage(){
        return "indexSimple";
    }

    /**
     * 127.0.0.1/account/register  -----get
     * @return
     */
    @GetMapping("/register")
    public String registerPage(){
        return "indexSimple";
    }


}
