package com.jiangls.spring.springioc.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Jiangls
 * @date 2022/11/4
 *
 * 注解Configuration作用：声明当前类是一个配置类
 * 注解ComponentScan作用：扫描组件，和注解Configuration一起使用，默认扫描当前包和所有子包
 * 注解EnableAutoConfiguration作用：
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpelConfig {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(SpelConfig.class, args);
        SpelConfig c = context.getBean("spelConfig", SpelConfig.class);
        System.out.println(c);

        // 获取文件内容
        File file = c.testFile.getFile();
        FileInputStream fi = new FileInputStream(file);
        byte[] bytes = new byte[2048];
        fi.read(bytes);
        System.out.println("testFile content is: " + new String(bytes));
        fi.close();

        context.close();
    }

    /**
     * spel语言支持在xml和注解中使用。Spring开发中经常涉及调用各种资源的情况，包含普通文件、网址、配置文件、系统环境变量等。</br>
     * 我们呢可以使用spel实现资源的注入。</br>
     * 字符串注入
     */
    @Value("str")
    private String str;

    /**
     * 操作系统变量注入
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 表达式运算结果注入
     */
    @Value("#{T(java.lang.Math).random() * 10}")
    private double randomDouble;

    /**
     * 其他Bean属性注入
     */
    @Value("#{innerClass.another}")
    private String another;

    /**
     * 文件内容注入
     */
    @Value("classpath:test.txt")
    private Resource testFile;

    /**
     * 网址内容注入
     */
    @Value("https://www.baidu.com")
    private Resource testUrl;

    /**
     * 属性文件中属性注入
     */
    @Value("${spring.jiangls.key}")
    private String key;


    @Bean
    public InnerClass innerClass() {
        return new InnerClass();
    }

    static class InnerClass {
        public String another = "another";

        public void greeting() {
            System.out.println("I am InnerClass!");
        }
    }


}
