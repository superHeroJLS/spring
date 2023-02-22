package com.jiangls.spring.springdataandtx.globaltxconfig;

import com.jiangls.spring.springdataandtx.globaltxconfig.service.ServiceA;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class GlobalTxConfig {


    /**事务拦截器*/
    @Bean("txAdvice")
    public TransactionInterceptor txAdvice(TransactionManager transactionManager){

        /*只读事务，不做更新操作*/
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED );

        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED,
                Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setTimeout(5);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("add*", requiredTx);
        txMap.put("query*", readOnlyTx);
        source.setNameMap( txMap );

        return new TransactionInterceptor(transactionManager, source) ;
    }

    /**切面拦截规则*/
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(TransactionInterceptor txAdvice){
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setAdvice(txAdvice);
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // service包下所有类所有方法
        pointcut.setExpression("execution (* com.jiangls.spring.springdataandtx.globaltxconfig.service.*.*(..))");
        pointcutAdvisor.setPointcut(pointcut);
        return pointcutAdvisor;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GlobalTxConfig.class, args);
        ServiceA sa = (ServiceA) context.getBean("serviceA");
        sa.add();
        sa.query();
    }
}
