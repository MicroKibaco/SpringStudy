package com.ai.test.beanannotation;

import com.ai.spring.beanannotation.jsr.JsrServie;
import com.ai.test.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;



@RunWith(BlockJUnit4ClassRunner.class)
public class TestJsr extends UnitTestBase {
	
	public TestJsr() {
		super("classpath*:spring-beanannotation.xml");
	}
	
	@Test
	public void testSave() {
		JsrServie service = getBean("jsrServie");
		service.save();
	}
	
}
