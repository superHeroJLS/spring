package com.jiangls.spring.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * scanBasePackages默认扫描当前包和所有子包
 */
@SpringBootApplication(scanBasePackages = {"com.jiangls.spring.springioc"})
public class SpringIocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        // print ApplicationContext info.
        System.out.println("start succcessful, context is " + context);
        System.out.println("context class is " + context.getClass().getSimpleName());
        System.out.println("context parent is " + context.getParent());
        if(context.getParent() != null) {
            System.out.println("context parent class is " + context.getParent().getClass().getSimpleName());
        }

        MyService service = context.getBean("myService", MyService.class);
        service.greeting();
    }

}
