package com.jiangls.spring.springioc;

import com.jiangls.spring.springioc.di.DiConfig;
import com.jiangls.spring.springioc.di.MyBizService;
import com.jiangls.spring.springioc.di.MyFuncService;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.naming.Context;

/**
 * 可以通过{@code @SpringBootTest}的属性classes指定Configuration类。<br>
 *
 * {@code @TestInstance(TestInstance.Lifecycle.PER_CLASS)}使{@code @BeforeAll}方法不需要是static方法。
 */
@SpringBootTest(classes = {DiConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringIocApplicationTests {

    @Resource
    private MyFuncService service;

    @Resource
    private MyBizService bizService;

    @Resource
    private ApplicationContext context;


    @BeforeAll
     void beforeAll() {
        System.out.println("----------before all, context is " + context);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----------before each");
    }

    @Test
    void greeting() {
        Assert.isTrue("i am MyFuncService!".equals(service.greeting()), "非预期的值");
    }

    @Test
    void bizgreeting() {
        bizService.greeting();
    }

    @AfterEach
    void afterEach() {
        System.out.println("----------after each");
    }

    @AfterAll
     void afterAll() {
        System.out.println("----------after all");
    }

}
