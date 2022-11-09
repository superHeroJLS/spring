package com.jiangls.spring.springboot.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2022/11/8
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {JmxAutoConfiguration.class})
public class BannerConfig {

    /**
     * srm/main/resources/目录下新建一个banner.txt
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication sp = new SpringApplication(BannerConfig.class);
        // 关闭Banner
        sp.setBannerMode(Banner.Mode.OFF);
        ApplicationContext context = sp.run(args);

        System.out.println(context);
    }
}
