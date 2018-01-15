package com.ai.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;

public class ExampleDisposableBean implements DisposableBean {
    public void destroy() throws Exception {
        System.out.println("");
    }
}
