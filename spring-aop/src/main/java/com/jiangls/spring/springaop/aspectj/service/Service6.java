package com.jiangls.spring.springaop.aspectj.service;

import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2023/1/6
 */
@Service("service6")
public class Service6 {

    public String method6(String arg) throws RuntimeException{
        System.out.println("this is Service6.method6");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method6");
        }
        return arg;
    }

}
