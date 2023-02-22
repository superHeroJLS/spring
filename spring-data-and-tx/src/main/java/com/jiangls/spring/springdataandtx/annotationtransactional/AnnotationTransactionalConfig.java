package com.jiangls.spring.springdataandtx.annotationtransactional;

import com.jiangls.spring.springdataandtx.annotationtransactional.service.ServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AnnotationTransactionalConfig {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AnnotationTransactionalConfig.class, args);
        ServiceB sa = (ServiceB) context.getBean("serviceB");
        sa.add();
        sa.query();
    }
}
