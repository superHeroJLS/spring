package com.jiangls.spring.springwebmvc.config;

import com.jiangls.spring.springwebmvc.config.filter.MyFilter;
import com.jiangls.spring.springwebmvc.config.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jiangls
 * @date 2021/12/16
 */
@Configuration
public class ServletFilterConfiguration {

    /**
     * 可以写多个 FilterRegistrationBean
     */

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/*");
        bean.setName("myfilter");
        // 值越小，优先级越高
        bean.setOrder(99);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> filterRegistrationBean2() {
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>();
        // 这里可以使用 new，也可以在 Filter 上加 @Component 注入进来
        bean.setFilter(new MyFilter2());
        bean.addUrlPatterns("/*");
        bean.setName("myfilter2");
        // 值越小，优先级越高
        bean.setOrder(100);
        return bean;
    }
}
