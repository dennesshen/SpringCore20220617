package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Car;
import com.spring.core.session03.beans.CarFactory;
import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.DBConn;
import com.spring.core.session03.beans.Teacher;

public class TestCar {
	@Test
	public void test() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car1 = ctx.getBean("carFactory", Car.class);
		Car car2 = ctx.getBean("carFactory", Car.class);
		
		System.out.println(car1);
		System.out.println(car2);

		
	}	
}
