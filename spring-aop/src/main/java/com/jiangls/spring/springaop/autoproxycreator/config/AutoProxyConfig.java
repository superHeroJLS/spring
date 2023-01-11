package com.jiangls.spring.springaop.autoproxycreator.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author Jiangls
 * @date 2023/1/11
 */
@Configuration
public class AutoProxyConfig {

    /**
     * 自定义MethodBeforeAdvice
     * @return
     */
    @Bean
    public MethodBeforeAdvice mba1() {
        return new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("this is MethodBeforeAdvice111");
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
                System.out.println("this is AfterReturningAdviceInterceptor.AfterReturningAdvice");
            }
        });
    }

    /**
     * 自定义Advisor
     * <ol>
     *     Advisor包括Pointcut和Advice
     *     <li>Pointcut：切点定义</li>
     *     <li>Advice：增强逻辑</li>
     * </ol>
     * @return
     */
    @Bean
    public Advisor nmmpa() {
        MethodBeforeAdvice mba2 = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("this is Advisor.MethodBeforeAdvice222");
            }
        };
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        // 切点：只对method111增强
        advisor.addMethodName("method111");
        // 增强：自定义MethodBeforeAdvice实现
        advisor.setAdvice(mba2);
        return advisor;
    }

    /**
     *
     * @return
     */
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        // 指定使用
        creator.setProxyTargetClass(true);
        creator.setOptimize(true);
        // 指定目标对象bean name
        creator.setBeanNames("service3","service4");
        // 接收advice、interceptor、advisor的bean name，传入参数的顺序就是代理对象增强的顺序
        creator.setInterceptorNames("mba1", "arai", "nmmpa");
        return creator;
    }
}
