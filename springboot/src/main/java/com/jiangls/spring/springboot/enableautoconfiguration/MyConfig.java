package com.jiangls.spring.springboot.enableautoconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/12/4
 */
@Configuration
public class MyConfig {

    @Bean
    public InterClas interClass() {
        return new InterClas();
    }

    class InterClas{

    }

}
