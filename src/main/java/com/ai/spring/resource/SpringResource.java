package com.ai.spring.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class SpringResource implements ApplicationContextAware {

    private ApplicationContext mContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.mContext = applicationContext;
    }


    public void resource() throws IOException {

        Resource res = mContext.getResource("config.txt");

        System.out.println("获取文件名称: " + res.getFilename() );
        System.out.println("获取文件长度: " + res.contentLength());
    }
}
