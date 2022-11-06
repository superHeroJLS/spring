package com.jiangls.spring.springioc.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * @ ComponentScan 默认扫描当前包和所有子包
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DiConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiConfig.class, args);
        MyBizService bizService = context.getBean("myBizService", MyBizService.class);
        bizService.greeting();
    }
}
