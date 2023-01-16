package com.jiangls.spring.springaop.aspectj.service.impl;

import com.jiangls.spring.springaop.aspectj.service.Service5;
import org.springframework.stereotype.Service;

@Service("service5")
public class Service5Impl implements Service5 {
    @Override
    public String method5(String arg) throws RuntimeException {
        System.out.println("this is Service5.method5");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method5");
        }
        return arg;
    }
}
