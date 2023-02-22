package com.jiangls.spring.springdataandtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DataAndTxApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DataAndTxApplication.class, args);
    }
}
