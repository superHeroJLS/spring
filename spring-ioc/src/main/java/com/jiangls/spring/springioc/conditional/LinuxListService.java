package com.jiangls.spring.springioc.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/11/6
 */
@Component
@Conditional(value = {LinuxCondition.class})
public class LinuxListService implements ListService{
    @Override
    public String showListCmd() {
        return "ls";
    }
}
