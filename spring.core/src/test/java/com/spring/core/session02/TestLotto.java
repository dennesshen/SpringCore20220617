package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session01.beans.Hello;
import com.spring.core.session01.conf.SpringConfig;
import com.spring.core.session02.beans.Lotto;

public class TestLotto {
	
	@Test
	public void test() {
		
		//利用Spring 來建立所取得的物件
		//透過applicationContext.xml 配置 來做物件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Lotto lotto1 = applicationContext.getBean("lotto1",  Lotto.class);
		System.out.println(lotto1);
		
		Lotto lotto2 = applicationContext.getBean("lotto1",  Lotto.class);
		System.out.println(lotto2);
		
		Lotto lotto3 = applicationContext.getBean("lotto2",  Lotto.class);
		System.out.println(lotto3);
		
		Lotto lotto4 = applicationContext.getBean("lotto2",  Lotto.class);
		System.out.println(lotto4);
		
		
	}
}
