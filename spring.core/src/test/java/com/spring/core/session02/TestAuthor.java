package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;

public class TestAuthor {
	
	

	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author1 = applicationContext.getBean("author1",Author.class);
		System.out.println(author1);
	
		Author author2 = applicationContext.getBean("author2",Author.class);
		System.out.println(author2);
		
		Author author3 = applicationContext.getBean("author3",Author.class);
		System.out.println(author3);
		
		Author author4 = applicationContext.getBean("author4",Author.class);
		System.out.println(author4);
		
		Author author5 = applicationContext.getBean("author5",Author.class);
		System.out.println(author5);
	
	}
}
