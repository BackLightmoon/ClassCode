package com.sfac.javaSpringBoot.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/20
 * Time: 18:48
 * Description: No Description
 */
@Controller
@RequestMapping("/common")
public class CommonContoller {

    /**
     * 127.0.0.1/common/dashboard   -----get
     * @return
     */
    @GetMapping("/dashboard")
    public String dashboardPage(){
        return "index";
    }
}
