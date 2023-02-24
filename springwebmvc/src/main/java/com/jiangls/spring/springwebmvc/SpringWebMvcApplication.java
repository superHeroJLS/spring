package com.jiangls.spring.springwebmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebMvcApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringWebMvcApplication.class, args);
        System.out.println(context.getClass().getName() + " " + context.getParent());
    }
}
