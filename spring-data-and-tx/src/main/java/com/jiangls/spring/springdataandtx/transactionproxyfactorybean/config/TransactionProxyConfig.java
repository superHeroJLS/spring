package com.jiangls.spring.springdataandtx.transactionproxyfactorybean.config;

import com.jiangls.spring.springdataandtx.transactionproxyfactorybean.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import java.util.Properties;

@Configuration
public class TransactionProxyConfig {

    /**
     * 我们通过TransactionProxyFactoryBean将bookServiceTarget封装成具有事务功能的bookService
     * @param bookServiceTarget
     * @param transactionManager
     * @return
     */
    @Bean
    public TransactionProxyFactoryBean bookService(BookService bookServiceTarget, PlatformTransactionManager transactionManager) {
        TransactionProxyFactoryBean tpfb = new TransactionProxyFactoryBean();
        tpfb.setTarget(bookServiceTarget);
        tpfb.setTransactionManager(transactionManager);
        Properties prop = new Properties();
        // find开头的方法事务传播：PROPAGATION_REQUIRED，只读
        prop.setProperty("find*", " PROPAGATION_REQUIRED,readOnly");
        tpfb.setTransactionAttributes(prop);

        return tpfb;
    }
}
