package com.jiangls.spring.springioc.initanddestory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
public class InitAndDestoryConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InitAndDestoryConfig.class, args);
    }

    @Bean
    public InnerClass innerClass() {
        return new InnerClass();
    }

    /**
     * 注解方式指定init和destory方法
     */
    static class InnerClass {

        @PostConstruct
        public void init() {
            System.out.println("InnerClass inited!");
        }

        public void greeting() {
            System.out.println("I am InnerClass!");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("InnerClass destroyed");
        }
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public InnerClass2 innerClass2() {
        return new InnerClass2();
    }

    /**
     * 注解Bean属性initMethod、destroyMethod指定init、destory
     */
    static class InnerClass2 {

        public void init() {
            System.out.println("InnerClass2 inited!");
        }

        public void greeting() {
            System.out.println("I am InnerClass2!");
        }

        public void destroy() {
            System.out.println("InnerClass2 destoryed");
        }
    }
}
