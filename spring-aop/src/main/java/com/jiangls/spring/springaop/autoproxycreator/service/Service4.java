package com.jiangls.spring.springaop.autoproxycreator.service;

import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2023/1/6
 */
@Service("service4")
public class Service4 {

    public String method333(String arg) throws RuntimeException{
        System.out.println("this is Service4.method333");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method333");
        }
        return arg;
    }

    public String method444(String arg) throws RuntimeException {
        System.out.println("this is Service4.method444");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method444");
        }
        return arg;
    }
}
