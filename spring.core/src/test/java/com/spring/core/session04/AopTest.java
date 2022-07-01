package com.spring.core.session04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Teacher;
import com.spring.core.session05.aop.MathCalc;

public class AopTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AopapplicationContext.xml");
		MathCalc mathCalc = ctx.getBean(MathCalc.class);
		MathCalc mathCalc2 = new MathCalc();
		mathCalc2.add(10, 2);
		mathCalc.add(10, 2);
	}	
}
