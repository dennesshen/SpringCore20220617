package com.spring.core.session04;

import org.junit.Test;

import com.spring.core.session04.dyn.Calc;
import com.spring.core.session04.dyn.CalcImp;
import com.spring.core.session04.dyn.ProxyDynUtil;
import com.spring.core.session04.sta.Man;
import com.spring.core.session04.sta.Person;



public class ProxyStaticDemo {
	@Test
	public void test() {
		Person man = (Person) new ProxyDynUtil(new Man()).getObject();
		Calc calc = (Calc) new ProxyDynUtil(new CalcImp()).getObject();
		
		man.work();
		
		calc.add(10, 20);
		
		calc.div(10, 0);
		

		
	}
}
