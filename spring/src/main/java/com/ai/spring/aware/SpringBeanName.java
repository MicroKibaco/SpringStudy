package com.ai.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanName implements BeanNameAware, ApplicationContextAware {

    private String beanName;

    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("SpringBeanName : " + name);
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("setApplicationContext : " + context.getBean(this.beanName).hashCode());
    }
}
