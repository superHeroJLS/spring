package com.jiangls.spring.springioc.di;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jiangls
 * @date 2022/11/4
 */
@Service
public class MyBizService {

    @Resource
    private MyFuncService funcService;

    public void greeting() {
        System.out.println(funcService.greeting());
    }
}
