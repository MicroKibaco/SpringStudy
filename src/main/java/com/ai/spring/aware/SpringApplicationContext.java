package com.ai.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringApplicationContext implements ApplicationContextAware  {


	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("SpringApplicationContext : " + applicationContext.getBean("SpringApplicationContext").hashCode());
	}
}
