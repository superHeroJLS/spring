package com.jiangls.spring.springboot.configurationproperties.usingenableconfigurationproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties({MyProperties.class})
public class MyPropertiesConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyPropertiesConfig.class, args);
        MyService js = context.getBean(MyService.class);
        js.printProperties();
    }
}
