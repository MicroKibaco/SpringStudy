package com.ai.spring.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SpringBeforeAdvice implements MethodBeforeAdvice {


	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("SpringBeforeAdvice : " + method.getName() + "     " +
				 target.getClass().getName());
	}

}
