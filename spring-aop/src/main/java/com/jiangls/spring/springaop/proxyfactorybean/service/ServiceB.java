package com.jiangls.spring.springaop.proxyfactorybean.service;

import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2023/1/6
 */
@Service("serviceBTarget")
public class ServiceB {

    public String methodC(String arg) throws RuntimeException{
        System.out.println("this is ServiceB.methodC");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in methodC");
        }
        return arg;
    }

    public String methodD(String arg) throws RuntimeException {
        System.out.println("this is ServiceB.methodD");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in methodD");
        }
        return arg;
    }
}
