package com.jiangls.spring.springdataandtx.globaltxconfig.service;

import org.springframework.stereotype.Service;

@Service("serviceA")
public class ServiceAImpl implements ServiceA{
    @Override
    public void add() {
        System.out.println("this is add method");
    }

    @Override
    public void query() {
        System.out.println("this is query method");
    }
}
