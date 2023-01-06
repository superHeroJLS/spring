package com.jiangls.spring.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * scanBasePackages默认扫描当前包和所有子包
 * @author jiangls
 */
@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);
        // print ApplicationContext info.
        System.out.println("start succcessful, context is " + context);
        System.out.println("context class is " + context.getClass().getSimpleName());
        System.out.println("context parent is " + context.getParent());
        if(context.getParent() != null) {
            System.out.println("context parent class is " + context.getParent().getClass().getSimpleName());
        }
    }

}
