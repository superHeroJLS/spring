package com.jiangls.spring.springaop.proxyfactorybean;

import com.jiangls.spring.springaop.proxyfactorybean.service.ServiceA;
import com.jiangls.spring.springaop.proxyfactorybean.service.ServiceB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * scanBasePackages默认扫描当前包和所有子包。<br><br>
 *
 * 验证ProxyFactoryBean。<br>
 * 方法context.getBean("serviceA") 实际上最终调用的是 ProxyFactoryBean.getobject() 方法，获取到的是AOP代理对象。<br>
 *
 * <ol>
 *     ProxyFactoryBean、目标对象（ServiceA）的实例化和初始化时机：
 *     <li>ApplicationContext启动的时候会实例化、初始化ProxyFactoryBean实例和目标对象实例。源码：AnnotationConfigApplicationContext.finishBeanFactoryInitialization</li>
 *     <li>调用context.getBean("serviceA")获取到的是代理对象实例（注意不是ProxyFactoryBean实例，也不是目标对象实例）。源码：DefaultListableBeanFactory.getObjectForBeanInstance</li>
 * </ol>
 * @author jiangls
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProxyFactoryBeanConfig {

    /**
     * 验证ProxyFactoryBean。<br>
     * 方法context.getBean("serviceA") 实际上最终调用的是 ProxyFactoryBean.getobject() 方法，获取到的是AOP代理对象。<br>
     *
     * <ol>
     *     <li>ApplicationContext启动的时候会实例化、初始化ProxyFactoryBean实例和目标对象实例。AnnotationConfigApplicationContext.finishBeanFactoryInitialization</li>
     *     <li>调用context.getBean("serviceA")获取到的是代理对象。DefaultListableBeanFactory.getObjectForBeanInstance</li>
     * </ol>
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProxyFactoryBeanConfig.class, args);

        ServiceA serviceA = (ServiceA) context.getBean("serviceA");
        serviceA.methodA("aaa");
        System.out.println();
        serviceA.methodB("bbb");
        System.out.println();

        ServiceB serviceB = (ServiceB) context.getBean("serviceB");
        serviceB.methodC("ccc");
        System.out.println();
        serviceB.methodD("ddd");
    }

}
