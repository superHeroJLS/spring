package com.jiangls.spring.springioc.enableannotation;

import com.jiangls.spring.springioc.annotation.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * 注解MyConfiguration是一个组合注解，组合了Configuration和ComponentScan
 * 注解EnableAutoConfiguration作用：
 */
@MyConfiguration
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
//@EnableAspectJAutoProxy
public class EnableAnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(EnableAnnotationConfig.class, args);
        System.out.println(context);
    }

}
