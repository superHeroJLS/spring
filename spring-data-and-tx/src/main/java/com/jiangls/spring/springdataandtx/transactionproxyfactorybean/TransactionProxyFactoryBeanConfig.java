package com.jiangls.spring.springdataandtx.transactionproxyfactorybean;

import com.jiangls.spring.springdataandtx.DataAndTxApplication;
import com.jiangls.spring.springdataandtx.transactionproxyfactorybean.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * scanBasePackages默认扫描当前包和所有子包。<br><br>
 * @author jiangls
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TransactionProxyFactoryBeanConfig {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TransactionProxyFactoryBeanConfig.class, args);
        BookService bs = (BookService) context.getBean("bookService");
        bs.find();
        bs.query();
    }
}
