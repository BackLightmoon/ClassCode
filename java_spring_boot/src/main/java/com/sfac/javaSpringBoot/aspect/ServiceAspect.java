package com.sfac.javaSpringBoot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/17
 * Time: 18:35
 * Description: No Description
 */
@Aspect
@Component
public class ServiceAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    @Pointcut("@annotation(com.sfac.javaSpringBoot.aspect.ServiceAnnotation)")
    @Order(2)
    public void servicePointCut(){}

    @Before(value = "com.sfac.javaSpringBoot.aspect.ServiceAspect.servicePointCut()")
    public void beforeController(JoinPoint joinPoint){
        //joinpoint 切入点，可以从其中获取到request对象
        LOGGER.debug("========This is before controller =========");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        LOGGER.debug("请求来源 :" + request.getRemoteUser());
        LOGGER.debug("请求URL :" + request.getRequestURL().toString());
        LOGGER.debug("请求方法 :" + request.getMethod());
        LOGGER.debug("响应方法 :" + joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        LOGGER.debug("请求参数 :" + Arrays.toString(joinPoint.getArgs()));
    }

    //包容before和after，日志在它们之前
    @Around(value = "com.sfac.javaSpringBoot.aspect.ServiceAspect.servicePointCut()")
    public Object aroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.debug("==== This is around controller ====== ");
        return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }

    @After(value = "com.sfac.javaSpringBoot.aspect.ServiceAspect.servicePointCut()")
    public void afterController(){
        LOGGER.debug("=== This is after controller ====");
    }

}
