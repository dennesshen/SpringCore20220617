package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.Teacher;
import com.spring.core.session05.aop.MathCalc;
import com.spring.core.session05.aop.job.Dancer;
import com.spring.core.session05.aop.job.Performance;
import com.spring.core.session05.aop.job.Singer;

public class AopTest {
	@Test
	public void test() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {
			dancer.perform();
		} catch (Exception e) {
			System.out.println(e); // 意外發生
			// 舞者轉換跑道
			// 改行去唱歌
			// dancer 透過 introducter(經紀人) 轉換跑道
			System.out.println("舞者轉歌者");
			Singer singer = (Singer) dancer;
			singer.sing();		}

	}	
}
