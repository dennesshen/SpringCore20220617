package com.spring.core.session04.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDynUtil {
	Object object; 
	Object result;
	
	public ProxyDynUtil(Object object) {
		this.object = object;
	}
	
	public Object getObject() {
		
		ClassLoader loader = object.getClass().getClassLoader();
		Class[] interfaces = object.getClass().getInterfaces();
		
		InvocationHandler handler = (proxy,  method,  args) -> {
			MyLogging.before(object.getClass(), method, args);
			
			try {
				result = method.invoke(object, args);
			} catch (Exception e) {
				MyLogging.exception(object.getClass(), method, e);
			}
			
			MyLogging.after(object.getClass(), method, result);
			return result;
		};
		
		
		
		
		return Proxy.newProxyInstance(loader, interfaces, handler); 
	}
	
	

}
