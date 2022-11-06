package com.jiangls.spring.springioc.di;

import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2022/11/4
 */
@Service
public class MyFuncService {

    public String greeting() {
        return "i am MyFuncService!";
    }
}
