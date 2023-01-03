package com.jiangls.spring.springioc.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jiangls
 * @date 2022/12/13
 *
 * 自定义MyBeanFactoryPostProcessor，包路径一定要包含在compnentScan中。建议使用这种方式。
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("------------my BeanFactoryPostProcessor");
    }
}
