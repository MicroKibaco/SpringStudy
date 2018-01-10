package com.ai.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {

    }

    public void afterPropertiesSet() throws Exception {

    }
}
