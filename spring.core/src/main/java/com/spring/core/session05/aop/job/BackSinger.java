package com.spring.core.session05.aop.job;

public class BackSinger implements Singer{

	@Override
	public void sing() {
		System.out.println("唱歌中");
	}

}
