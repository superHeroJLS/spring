package com.jiangls.spring.springioc.applicationevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/11/6
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        Object source = event.getSource();
        System.out.println("DemoListener has received msg: " + msg + " from DemoEvent, DemoEvent source is " + source);
    }
}
