package com.jiangls.spring.springboot.enableautoconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/11/8
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class})
public class EnableAutoConfig {

    /**
     * {@code @EnableAutoConfiguration}作用：让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置。
     * <ol>
     *     <li>例如，添加了spring-boot-starter-web 依赖（自动添加Tomcat和Spring MVC的依赖），那么Spring Boot会对Tomcat和Spring MVC进行自动配置。</li>
     *     <li>又如，添加了spring-boot starter-data-jpa依赖，Spring Boot会自动进行JPA相关的配置。</li>
     * </ol>
     * {@code @EnableAutoConfiguration}属性作用：
     * <ol>
     *     <li>exclude：等价于{@code @EnableAutoConfiguration}的exclude属性，关闭特定的自定配置，及不实例化也不配置指定的*AutoConfiguration类</li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(EnableAutoConfig.class, args);
        System.out.println(context);
    }
}
