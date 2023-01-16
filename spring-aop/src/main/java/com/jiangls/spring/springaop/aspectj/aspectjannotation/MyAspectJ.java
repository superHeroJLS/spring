package com.jiangls.spring.springaop.aspectj.aspectjannotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 要使用aspect注解，例如@Aspect，@Before，必须要添加依赖spring-boot-starter-aop
 */
@Component("myAspectj")
@Aspect
public class MyAspectJ {

    @Before(value = "execution(* com.jiangls.spring.springaop.aspectj.service.Service5.*(..)) && args(arg,..)")
    public void before1(String arg) {
        System.out.println("this is before advice, arg is : " + arg);
    }

    @After(value = "execution(* com.jiangls.spring.springaop.aspectj.service.Service6.*(..)) && args(arg,..)")
    public void after1(String arg) {
        System.out.println("this is after advice, arg is : " + arg);
    }
}
