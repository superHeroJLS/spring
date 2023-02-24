package com.jiangls.spring.springwebmvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jiangls
 * @date 2023/2/23
 */
@RestController
@RequestMapping("my")
public class MyController {

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("hello")
    public String hello(@RequestParam(value = "key", required = false) String key) {
        return "hello " + key;
    }
}
