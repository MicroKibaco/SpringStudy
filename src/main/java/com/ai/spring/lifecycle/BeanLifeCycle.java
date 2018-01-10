package com.ai.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        System.out.println("Bean destroy.");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet.");
    }

    private void start() {
        System.out.println("Bean start .");
    }

    private void stop() {
        System.out.println("Bean stop .");
    }

    private void defaultInit() {
        System.out.println("Bean defaultInit .");
    }

    private void defaultDestroy() {
        System.out.println("Bean defaultDestroy .");

    }
}
