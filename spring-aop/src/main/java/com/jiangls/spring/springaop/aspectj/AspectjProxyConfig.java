package com.jiangls.spring.springaop.aspectj;

import com.jiangls.spring.springaop.aspectj.service.Service5;
import com.jiangls.spring.springaop.aspectj.service.Service6;
import com.jiangls.spring.springaop.autoproxycreator.service.Service3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * scanBasePackages默认扫描当前包和所有子包。<br><br>
 * <block>@EnableAspectJAutoProxy不加直接使用Aspectj注解例如@Aspect都有效，<br>
 * 这是因为SpringBoot自动配置类AopAutoConfiguration加了注解@EnableAspectJAutoProxy对Aspectj注解进行了生效
 * </block>
 * @author jiangls
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
//@EnableAspectJAutoProxy
public class AspectjProxyConfig {

    /**
     * 验证Aspectj注解实现aop proxy<br>
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AspectjProxyConfig.class, args);

        Service5 s5 = context.getBean("service5", Service5.class);
        s5.method5("5");
        System.out.println();

        Service6 s6 = context.getBean("service6", Service6.class);
        s6.method6("6");
        System.out.println();
    }
}
