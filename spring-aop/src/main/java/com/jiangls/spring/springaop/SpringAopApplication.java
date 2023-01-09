package com.jiangls.spring.springaop;

import com.jiangls.spring.springaop.proxyfactorybean.service.ServiceA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * scanBasePackages默认扫描当前包和所有子包。
 * @author jiangls
 */
@SpringBootApplication
public class SpringAopApplication {

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
        ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);
        // print ApplicationContext info.
        System.out.println("start succcessful, context is " + context);
        System.out.println("context class is " + context.getClass().getSimpleName());
        System.out.println("context parent is " + context.getParent());
    }

}
