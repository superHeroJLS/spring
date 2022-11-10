package com.jiangls.spring.springboot.configurationproperties.usingenableconfigurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jiangls
 * @date 2022/11/8
 */
@Service
public class MyService {

    @Resource
    private MyProperties properties;

    @Value("${spring.application.name}")
    private String applicationName;

    public void printProperties() {
        System.out.println(properties.getName());
        System.out.println(properties.getAddress());
        System.out.println(applicationName);
    }
}
