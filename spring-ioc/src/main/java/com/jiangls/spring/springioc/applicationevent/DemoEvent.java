package com.jiangls.spring.springioc.applicationevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author Jiangls
 * @date 2022/11/6
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
