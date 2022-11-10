package com.jiangls.spring.springboot.configurationproperties.enableannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jiangls
 * @date 2022/11/8
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
public class EnableAnnotationConfig {

    /**
     * {@code @Enable*}注解的工作原理，通过简单的{@code @Enable*}来开启一项功能的支持，从而避免自己配置大量的代码，大大降低使用难度。<br>
     * 那么这个神奇的功能的实现原理是什么呢?我们一起来研究一下。<br>
     * 通过观察这些@Enable*注解的源码，我们发现所有的注解都有一个@Import注解,{@code @Import}是用来导入配置类的，<br>
     * 这也就意味着这些自动开启的实现其实是导入了一些自动配置的Bean。这些导入的配置方式主要分为以下三种类型。
     * <ol>
     *     <li>直接导入配置类：{@code @EnableScheduling}</li>
     *     <li>依据条件选择配置类：{@code @EnableAsync}</li>
     *     <li>动态注册Bean：{@code @EnableAspectJAutoProxy}</li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(EnableAnnotationConfig.class, args);
        System.out.println(context);
    }
}
