package com.jiangls.spring.springioc;

import org.springframework.stereotype.Service;

/**
 * @author Jiangls
 * @date 2022/11/4
 */
@Service
public class MyService {
    public void greeting() {
        System.out.println("i am MyService!");
    }
}
