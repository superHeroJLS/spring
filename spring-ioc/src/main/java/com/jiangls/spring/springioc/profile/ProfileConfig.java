package com.jiangls.spring.springioc.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

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
public class ProfileConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(ProfileConfig.class, args);
        String profile = context.getEnvironment().getProperty("spring.profiles.active");
        System.out.println("profile is " + profile);

        List<String> beanDefinitionNames = Arrays.asList(context.getBeanDefinitionNames());
        System.out.println("context has innerClass: " + beanDefinitionNames.contains("innerClass"));
        System.out.println("context has innerClass2: " + beanDefinitionNames.contains("innerClass2"));

        context.close();
    }

    @Bean
    @Profile("dev")
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass {
        public void greeting() {
            System.out.println("I am InnerClass!");
        }
    }

    @Bean
    @Profile("test")
    public InnerClass2 innerClass2() {
        return new InnerClass2();
    }

    static class InnerClass2 {
        public void greeting() {
            System.out.println("I am InnerClass2!");
        }
    }
}
