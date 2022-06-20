package com.spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;
import com.spring.core.session01.conf.SpringConfig;

public class TestHello2 {
	
	@Test
	public void test() {
		
		//利用Spring 來建立所取得的物件
		//透過applicationContext.xml 配置 來做物件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello1 = applicationContext.getBean(Hello.class);
		System.out.println(hello1);
		
		Hello hello2 = applicationContext.getBean("Hello",Hello.class);
		System.out.println(hello2);
		
		//使用JAVA配置
		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SpringConfig.class);
		Hello hello3 = applicationContext2.getBean(Hello.class);
		Hello hello4 = applicationContext2.getBean("hello",Hello.class);
		System.out.println(hello3);
	}
}
