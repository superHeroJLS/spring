package com.jiangls.spring.springioc.di;

import org.springframework.context.annotation.Bean;

/**
 * @author Jiangls
 * @date 2022/11/4
 */
public class OtherConfiguration {

    @Bean
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass{

    }

}
