package com.jiangls.spring.springboot.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/11/8
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
