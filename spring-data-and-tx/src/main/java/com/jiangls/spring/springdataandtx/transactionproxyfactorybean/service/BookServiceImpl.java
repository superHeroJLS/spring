package com.jiangls.spring.springdataandtx.transactionproxyfactorybean.service;

import org.springframework.stereotype.Service;

@Service("bookServiceTarget")
public class BookServiceImpl implements BookService {
    @Override
    public void find() {
        System.out.println("this is BookService.find method");
    }

    @Override
    public void query() {
        System.out.println("this is BookService.query method");
    }
}
