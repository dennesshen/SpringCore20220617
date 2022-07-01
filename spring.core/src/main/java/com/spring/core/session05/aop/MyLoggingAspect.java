package com.spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyLoggingAspect {
	 
	//@Before(value = "execution(public Integer com.spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式 Spring EL : execution(..)
	@Before(value = "execution(* com.spring.core.session05.aop.MathCalc.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("前置通知:"+ methodName + "," + Arrays.toString(args));
	}

}
