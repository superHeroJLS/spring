package com.jiangls.spring.springaop.autoproxycreator.service.impl;

import com.jiangls.spring.springaop.autoproxycreator.service.Service3;
import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2023/1/11
 */
@Service("service3")
public class Service3Impl implements Service3 {
    @Override
    public String method111(String arg) throws RuntimeException {
        System.out.println("this is Service3.method111");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method111");
        }
        return arg;
    }

    @Override
    public String method222(String arg) throws RuntimeException {
        System.out.println("this is Service3.method222");
        if ("exception".equals(arg)) {
            throw new RuntimeException("exception occurred in method222");
        }
        return arg;
    }
}
