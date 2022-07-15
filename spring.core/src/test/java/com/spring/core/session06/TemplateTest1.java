package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TemplateTest1 {
	
	@Test
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		
	}
}
