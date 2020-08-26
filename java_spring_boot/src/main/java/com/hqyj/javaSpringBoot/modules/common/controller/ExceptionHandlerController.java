package com.hqyj.javaSpringBoot.modules.common.controller;

import com.hqyj.javaSpringBoot.modules.common.vo.Result;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/26
 * Time: 19:10
 * Description: No Description
 */
@ControllerAdvice           //异常注解类
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerController {

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result<String> handle403(){
        return new Result<String>(Result.ResultStatus.FAILED.status
                ," ","/common/403");
    }

}
