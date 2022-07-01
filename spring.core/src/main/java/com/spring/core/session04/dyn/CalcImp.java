package com.spring.core.session04.dyn;

public class CalcImp implements Calc{

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int div(int x, int y) {
		return x/y;
	}
	
}
