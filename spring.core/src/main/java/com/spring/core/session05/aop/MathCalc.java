package com.spring.core.session05.aop;

import org.springframework.stereotype.Component;

@Component
public class MathCalc {
	
	public void add(int x, int y) {
		System.out.println("result:" + (x+y));
	}
	
	public void div(int x, int y) {
		System.out.println("result:" + (x/y));
	}

}
