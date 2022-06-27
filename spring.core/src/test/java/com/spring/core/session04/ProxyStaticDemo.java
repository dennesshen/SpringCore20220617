package com.spring.core.session04;

import org.junit.Test;

public class ProxyStaticDemo {
	@Test
	public void test() {
		//不代理直接執行
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();
		
		Person man2 = new PersonProxy(new Man());
		Person woman2 = new PersonProxy(new Woman());
		man2.work();
		woman2.work();

		
	}
}
