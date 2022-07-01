package com.spring.core.session04.dyn;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyLogging {
	
	public static void before(Class clazz, Method method, Object[] args) {
		System.out.println("前置通知 ->" + clazz.toString()+","+method.getName()+":" + Arrays.toString(args) );
	} 
	
	public static void exception(Class clazz, Method method, Throwable throwable) {
		System.out.println("例外通知 ->" + clazz.toString()+","+method.getName()+":" + throwable );
	} 
	
	public static void after(Class clazz, Method method, Object result) {
		System.out.println("後置通知 ->" + clazz.toString()+","+method.getName()+": result:" + result );
	} 

}
