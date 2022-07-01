package com.spring.core.session04;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import com.spring.core.session04.Cglib.Hello;
import com.spring.core.session04.Cglib.MyMethodInteceptor;

public class CglibDemo {
	 @Test
	 public void test() {
		 Enhancer enhancer = new Enhancer();
		 enhancer.setSuperclass(Hello.class);
		 enhancer.setCallback(new MyMethodInteceptor());
		 
		 Hello hello = (Hello)enhancer.create();
		 hello.sayhello("Mary");
		 
	 }
}
