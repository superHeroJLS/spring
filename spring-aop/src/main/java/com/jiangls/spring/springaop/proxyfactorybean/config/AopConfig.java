package com.jiangls.spring.springaop.proxyfactorybean.config;

import com.jiangls.spring.springaop.proxyfactorybean.service.ServiceA;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 直接定义ProxyFactoryBean用于生成AOP代理对象。
 *
 * @author Jiangls
 * @date 2023/1/6
 */
@Configuration
public class AopConfig {

    /**
     * 自定义MethodBeforeAdvice
     * @return
     */
     @Bean
     public MethodBeforeAdvice mba1() {
         return new MethodBeforeAdvice() {
             @Override
             public void before(Method method, Object[] args, Object target) throws Throwable {
                 System.out.println("this is mba1");
             }
         };
     }

    /**
     * 自定义AfterReturningAdviceInterceptor
     * @return
     */
     @Bean
     public AfterReturningAdviceInterceptor arai() {
         return new AfterReturningAdviceInterceptor(new AfterReturningAdvice() {
             @Override
             public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                 System.out.println("this is after returning advice interceptor");
             }
         });
     }

     @Bean
     public Advisor nmmpa() {
         MethodBeforeAdvice mba2 = new MethodBeforeAdvice() {
             @Override
             public void before(Method method, Object[] args, Object target) throws Throwable {
                 System.out.println("this is mba2 advisor");
             }
         };
         NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
         // 只对methodA增强
         advisor.addMethodName("methodA");
         advisor.setAdvice(mba2);
         return advisor;
     }

    /**
     * 代理对象的bean name：serviceA。 <br>
     * 目标对象的bean name: serviceATarget。 <br><br>
     *
     * 我们真正需要使用的是代理对象，代理对象对目标对象进行了增强。
     * @param serviceATarget
     * @return
     */
    @Bean
    public ProxyFactoryBean serviceA(ServiceA serviceATarget) {
        ProxyFactoryBean pf = new ProxyFactoryBean();
        pf.setTarget(serviceATarget);
        // 接收advice、interceptor、advisor的bean name，传入参数的顺序就是代理对象增强的顺序
        pf.setInterceptorNames("mba1", "arai", "nmmpa");
        return pf;
    }



}
