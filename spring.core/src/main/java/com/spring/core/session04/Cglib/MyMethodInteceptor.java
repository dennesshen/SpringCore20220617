package com.spring.core.session04.Cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyMethodInteceptor implements MethodInterceptor  {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("請出示實連制");
		return proxy.invokeSuper(object, args);
	}
	

}
