package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Teacher;
import com.spring.core.session05.aop.MathCalc;

public class AopJobTest {
	@Test
	public void test() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("AopapplicationContext.xml");
//		MathCalc mathCalc = ctx.getBean(MathCalc.class);
//		MathCalc mathCalc2 = new MathCalc();
//		mathCalc2.add(10, 2);
//		
//		mathCalc.add(10, 2);
		
		
		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AOPConfig.class);
		MathCalc mathCalc3 = ctx1.getBean(MathCalc.class);
		try {
			mathCalc3.add(10,11);
			mathCalc3.div(10, 2);
			mathCalc3.div(10, 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}	
}
