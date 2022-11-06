package com.jiangls.spring.springioc.beanscope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

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
public class BeanScopeConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(BeanScopeConfig.class, args);
        BeanDefinition bd = context.getBeanDefinition("innerClass");
        System.out.println("Bean innerClass scope is singleton: " + bd.isSingleton());
        BeanDefinition bd2 = context.getBeanDefinition("innerClass2");
        System.out.println("Bean innerClass2 scope is prototype: " + bd2.isPrototype());

        context.close();
    }

    /**
     * 注解Bean作用：当前方法返回值为一个Bean实例
     * 注解Scope作用：Bean实例作用域
     * @return
     */
    @Bean
    @Scope("singleton")
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass {
        public void greeting() {
            System.out.println("I am InnerClass!");
        }
    }

    /**
     * 注解Bean作用：当前方法返回值为一个Bean实例
     * 注解Scope作用：Bean实例作用域
     * @return
     */
    @Bean
    @Scope("prototype")
    public InnerClass2 innerClass2() {
        return new InnerClass2();
    }

    static class InnerClass2 {
        public void greeting() {
            System.out.println("I am InnerClass2!");
        }
    }
}
