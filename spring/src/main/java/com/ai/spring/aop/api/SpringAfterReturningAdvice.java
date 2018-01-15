package com.ai.spring.aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class SpringAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("SpringAfterReturningAdvice : " + method.getName() + "     " +
			target.getClass().getName() + "       " + returnValue);
	}

}
