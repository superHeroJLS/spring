package com.jiangls.spring.springboot.configurationproperties.notusingenableconfigurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2022/11/8
 */
@Service
public class JianglsService {

    @Autowired
    private JianglsProperties properties;

    @Value("${spring.application.name}")
    private String applicationName;

    public void printProperties() {
        System.out.println(properties.getName());
        System.out.println(properties.getAddress());
        System.out.println(applicationName);
    }
}
