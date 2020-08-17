package com.sfac.javaSpringBoot.aspect;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/17
 * Time: 18:35
 * Description: No Description
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceAnnotation {
    String value() default "aaa";
}
