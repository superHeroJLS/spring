package com.jiangls.spring.springboot.configurationproperties.notusingenableconfigurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/11/8
 *
 * <ol>
 *     使用{@code @ConfigurationProperties方法}
 *     <li>方法一：{@code @ConfigurationProperties}和{@code @Component}组合使用，此时被注解的类注册为Bean</li>
 * </ol>
 */
@Component
@ConfigurationProperties(prefix = "jiangls")
public class JianglsProperties {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
