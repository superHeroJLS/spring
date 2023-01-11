package com.jiangls.spring.springaop.autoproxycreator.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
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
        advisor.addMethodName("method333");
        // 增强：自定义MethodBeforeAdvice实现
        advisor.setAdvice(mba2);
        return advisor;
    }

    /**
     * <ol>
     *     使用BeanNameAutoProxyCreator生成代理。
     *     <li>1 指定多个目标对象的bean name</li>
     *     <li>2 指定interceptorNames（可以包括advice、interceptor、advisor）</li>
     * </ol>
     * <ol>
     *     BeanNameAutoProxyCreator生成代理的原理：
     *     方法BeanNameAutoProxyCreator.postProcessAfterInitialization(@Nullable Object bean, String beanName)，
     *     会在目标对象初始化后生成代理对象替代目标对象。
     * </ol>
     * @return
     */
    /*@Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
        // 指定使用cglib动态代理
        creator.setProxyTargetClass(true);
        creator.setOptimize(true);

        // 指定目标对象bean name
        creator.setBeanNames("service3","service4");
        // 接收advice、interceptor、advisor的bean name，传入参数的顺序就是代理对象增强的顺序
        creator.setInterceptorNames("mba1", "arai", "nmmpa");
        return creator;
    }*/

    /**
     * <ol>
     *     使用DefaultAdvisorAutoProxyCreator生成代理。使用DefaultAdvisorAutoProxyCreator只需要通过@Bean配置实例即可完成自动代理功能。<br>
     * </ol>
     * <ol>
     *     BeanNameAutoProxyCreator生成代理的原理：
     *     <li>方法BeanNameAutoProxyCreator.postProcessAfterInitialization(@Nullable Object bean, String beanName)，
     *     会在目标对象初始化后生成代理对象替代目标对象。</li>
     *     <li>DefaultAdvisorAutoProxyCreator将找出所有的Advisor (注意:仅Advisor会被列举出来，Advice都将被忽略)和普通的Bean,
     *     然后根据Advisor计算它们能够适用于哪些Bean,凡是能被适用的Bean都将被自动创建AOP代理，整个过程全部由
     *     DefaultAdvisorAutoProxyCreator完成，完全不需要手动配置任何AOP代理对象。</li>
     * </ol>
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        // 指定使用cglib动态代理
        creator.setProxyTargetClass(true);
        creator.setOptimize(true);
        return creator;
    }
}
