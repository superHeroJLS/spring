package com.jiangls.spring.springdataandtx.annotationtransactional.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceB")
public class ServiceBImpl implements ServiceB{

    @Transactional
    @Override
    public void add() {
        System.out.println("this is add method");
    }

    @Transactional
    @Override
    public void query() {
        System.out.println("this is query method");
    }
}
