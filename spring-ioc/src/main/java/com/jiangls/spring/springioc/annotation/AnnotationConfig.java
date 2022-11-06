package com.jiangls.spring.springioc.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * 注解MyConfiguration是一个组合注解，组合了Configuration和ComponentScan
 * 注解EnableAutoConfiguration作用：
 */
@MyConfiguration
@EnableAutoConfiguration
public class AnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(AnnotationConfig.class, args);
        System.out.println(context);
    }

}
