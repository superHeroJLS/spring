package com.jiangls.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.jiangls.spring.springboot", exclude = {JmxAutoConfiguration.class})
public class MySpringBootApplication {

    /**
     * {@code @SpringBootApplication}作用：@SpringBootApplication注解主要组合了{@code @Configuration、@EnableAutoConfiguration、@ComponentScan;}
     * 若不使用{@code @SpringBootApplication}注解，则可以在入口类上直接使用{@code @Configuration、@EnableAutoConfiguration、 @ComponentScan}
     * <ol>
     *     {@code @SpringBootApplication}中一些属性的作用：
     *     <li>scanBasePackages：等价于{@code @ComponentScan}的basePackages属性，扫描组件，和注解Configuration一起使用，属性scanBasePackages默认扫描当前包和所有子包里面的Bean</li>
     *     <li>exclude：等价于{@code @EnableAutoConfiguration}的exclude属性，关闭特定的自定配置，及不实例化也不配置指定的*AutoConfiguration类</li>
     * </ol>
     * <br>
     *
     * {@code @Configuration}作用：声明当前类是一个配置类。<br><br>
     * {@code @ComponentScan}作用：扫描组件，和注解Configuration一起使用，属性basePackages默认扫描当前包和所有子包里面的Bean<br><br>
     * {@code @EnableAutoConfiguration}作用：让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置。
     * <ol>
     *     <li>例如，添加了spring-boot-starter-web 依赖（自动添加Tomcat和Spring MVC的依赖），那么Spring Boot会对Tomcat和Spring MVC进行自动配置。</li>
     *     <li>又如，添加了spring-boot starter-data-jpa依赖，Spring Boot会自动进行JPA相关的配置。</li>
     * </ol>
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);
        System.out.println(context);
    }

}
