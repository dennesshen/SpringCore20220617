package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session06.template.EmpDao;

public class TemplateTest1 {
	
	@Test
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		EmpDao empDao = applicationContext.getBean("empDao", EmpDao.class);
		
		empDao.queryAll().forEach(System.out::println);	
		
		System.out.println("自訂RowMapper :" + empDao.queryAllEmps1());
		System.out.println("BeanPropertyRowMapper :" + empDao.queryAllEmps2());

		
	}
}
