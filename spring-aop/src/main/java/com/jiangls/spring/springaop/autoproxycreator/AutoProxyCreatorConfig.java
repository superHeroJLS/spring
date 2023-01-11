package com.jiangls.spring.springaop.autoproxycreator;

import com.jiangls.spring.springaop.autoproxycreator.service.Service3;
import com.jiangls.spring.springaop.autoproxycreator.service.Service4;
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
public class AutoProxyCreatorConfig {

    /**
     * 验证自动代理AutoProxyCreator。<br>
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AutoProxyCreatorConfig.class, args);

        Service3 s3 = context.getBean("service3", Service3.class);
        s3.method111("111");
        System.out.println();
        s3.method222("222");
        System.out.println();

        Service4 s4 = context.getBean("service4", Service4.class);
        s4.method333("333");
        System.out.println();
        s4.method444("444");

    }

}
