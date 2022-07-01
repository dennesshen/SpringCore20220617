package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Clazz;
import com.spring.core.session03.beans.DBConn;
import com.spring.core.session03.beans.Teacher;

public class TestDbconn {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConn conn = ctx.getBean("dbconn", DBConn.class);
		conn.query();
		
		((ClassPathXmlApplicationContext) ctx).close();
	}	
}
