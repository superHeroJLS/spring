package com.jiangls.spring.springioc.di;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * 注解Configuration作用：声明当前类是一个配置类
 * 注解ComponentScan作用：扫描组件，和注解Configuration一起使用，默认扫描当前包和所有子包
 * 注解EnableAutoConfiguration作用：
 */
@Configuration
@ComponentScan(basePackages = {"com.jiangls.spring.springioc.di"})
@EnableAutoConfiguration
public class DiConfig {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiConfig.class, args);
        System.out.println(context);

        InnerClass ic = context.getBean("innerClass", InnerClass.class);
        System.out.println(ic);
    }

    /**
     * 注解Bean作用：当前方法返回值为一个Bean
     * @return
     */
    @Bean
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass implements DisposableBean{

        public InnerClass() {
        }

        @PostConstruct
        public void init() {
            System.out.println("this is init method");
        }

        public void greeting() {
            System.out.println("I am InnerClass!");
        }

        @Override
        public void destroy() throws Exception {
            System.err.println("----------this is destroy method override Interface DisposableBean");
        }

        /**
         * 这个方法在destroy()方法之前执行
         */
        @PreDestroy
        public void des() {
            System.err.println("----------this is custom des method annotated @PreDestroy");
        }
    }

    /**
     * 自定义BeanFactoryPostProcessor，方法一定要加static，原因参考@Bean。不建议使用这种方式
     */
   /* @Bean
    public static BeanFactoryPostProcessor bfpp() {
        return new MyBeanFactoryPostProcessor();
    }

    static class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("my BeanFactoryPostProcessor");
        }
    }*/
}
