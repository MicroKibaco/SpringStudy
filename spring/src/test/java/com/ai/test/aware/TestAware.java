package com.ai.test.aware;

import com.ai.test.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAware extends UnitTestBase {
	
	public TestAware() {
		super("classpath:spring-aware.xml");
	}
	
//	@Test
//	public void testSpringApplicationContext() {
//		System.out.println("testSpringApplicationContext : " + super.getBean("SpringApplicationContext").hashCode());
//	}
	
	@Test
	public void textSpringBeanName() {
		System.out.println("textSpringBeanName : " + super.getBean("SpringBeanName").hashCode());
	}
	
}
