package com.jiangls.spring.springboot.configurationproperties.notusingenableconfigurationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/11/8
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PropertiesConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PropertiesConfig.class, args);
        JianglsService js = context.getBean(JianglsService.class);
        js.printProperties();
    }
}
