package com.jiangls.spring.springioc.applicationevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * 注解Configuration作用：声明当前类是一个配置类
 * 注解ComponentScan作用：扫描组件，和注解Configuration一起使用，默认扫描当前包和所有子包
 * 注解EnableAutoConfiguration作用：
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class EventConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(EventConfig.class, args);
        context.publishEvent(new DemoEvent(context, "hello"));

        context.close();
    }

}
