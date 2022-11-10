package com.jiangls.spring.springboot.configurationproperties.usingenableconfigurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/11/8
 *
 * <ol>
 *     使用{@code @ConfigurationProperties方法}
 *     <li>方法二：{@code @ConfigurationProperties}和{@code @EnableConfigurationProperties({MyProperties.class})}组合使用，此时被注解的类注册为Bean</li>
 * </ol>
 */
@ConfigurationProperties(prefix = "my")
public class MyProperties {

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
