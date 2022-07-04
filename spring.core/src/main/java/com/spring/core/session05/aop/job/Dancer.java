package com.spring.core.session05.aop.job;

import java.util.Date;

public class Dancer implements Performance{

	@Override
	public void perform() {
		System.out.println("Dancer開始跳舞.....");
		
		if (new Date().getTime() % 3 == 0 ) throw new RuntimeException("舞者跌倒了");
	
		System.out.println("Dancer結束跳舞.....");

	}

}
