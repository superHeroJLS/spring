package com.jiangls.spring.springioc.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
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
@ComponentScan(basePackages = {"com.jiangls.spring.springioc.di"})
@EnableAutoConfiguration
public class DiConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiConfig.class, args);
        MyBizService bizService = context.getBean("myBizService", MyBizService.class);
        bizService.greeting();

        InnerClass ic = context.getBean("innerClass", InnerClass.class);
        ic.greeting();
    }

    /**
     * 注解Bean作用：当前方法返回值为一个Bean
     * @return
     */
    @Bean
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass {
        public void greeting() {
            System.out.println("I am InnerClass!");
        }
    }
}
