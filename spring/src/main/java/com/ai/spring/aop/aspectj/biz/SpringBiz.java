package com.ai.spring.aop.aspectj.biz;

import com.ai.spring.aop.aspectj.SpringMethod;

import org.springframework.stereotype.Service;


@Service
public class SpringBiz {
	
	@SpringMethod("SpringBiz save with SpringMethod.")
	public String save(String arg) {
		System.out.println("SpringBiz save : " + arg);
//		throw new RuntimeException(" Save failed!");
		return " Save success!";
	}

}
