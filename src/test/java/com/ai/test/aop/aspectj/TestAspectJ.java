package com.ai.test.aop.aspectj;

import com.ai.spring.aop.aspectj.biz.SpringBiz;
import com.ai.test.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;



@RunWith(BlockJUnit4ClassRunner.class)
public class TestAspectJ extends UnitTestBase {
	
	public TestAspectJ() {
		super("classpath:spring-aop-aspectj.xml");
	}
	
	@Test
	public void test() {
		SpringBiz biz = getBean("springBiz");
		biz.save("This is test.");
	}
	
}
