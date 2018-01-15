package com.ai.spring.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SpringMethodInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("SpringMethodInterceptor 1 : " + invocation.getMethod().getName() + "     " +
				invocation.getStaticPart().getClass().getName());
		 Object obj = invocation.proceed();
		 System.out.println("SpringMethodInterceptor 2 : " + obj);
		 return obj;
	}

}
