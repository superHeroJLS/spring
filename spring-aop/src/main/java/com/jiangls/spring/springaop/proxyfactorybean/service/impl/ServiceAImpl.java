package com.jiangls.spring.springaop.proxyfactorybean.service.impl;

import com.jiangls.spring.springaop.proxyfactorybean.service.ServiceA;
import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2023/1/6
 */
@Service("serviceATarget")
public class ServiceAImpl implements ServiceA {
    @Override
    public String methodA(String arg) throws RuntimeException{
        System.out.println("this is methodA");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in methodA");
        }
        return arg;
    }

    @Override
    public String methodB(String arg) throws RuntimeException {
        System.out.println("this is methodB");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in methodB");
        }
        return arg;
    }
}
