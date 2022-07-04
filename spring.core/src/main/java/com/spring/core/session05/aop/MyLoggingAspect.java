package com.spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyLoggingAspect {

	// 建立切入點方法
	@Pointcut(value = "execution(* com.spring.core.session05.aop.MathCalc.*(..))")
	public void point() {
	}

	@Pointcut(value = "execution(* com.spring.core.session05.aop.MathCalc.div(..))")
	public void point2() {
	}

	// 前置通知 Advice
	// @Before(value = "execution(public Integer
	// com.spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式
	// Spring EL : execution(..)
	// @Before(value = "execution(*
	// com.spring.core.session05.aop.MathCalcImpl.*(..))") // * 表示任意方法, .. 表示0~多任意參數
	// @Before(value = "execution(public *
	// com.spring.core.session05.aop.MathCalcImpl.*(..))")
	// @Before(value = "execution(* com.spring.core.session05.aop.*.*(..))") //
	// 在指定套件下之任意類 + 任意方法
	// @Before(value = "execution(* *(..))") // 全部攔截
	// @Before(value = "execution(public Integer
	// com.spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式
	// Spring EL : execution(..)

	// @Before(value = "execution(* com.spring.core.session05.aop.MathCalc.*(..))")
	// // AOP 切點

	@Before(value = "point() && !point2()")
	public void beforeAdvice(JoinPoint joinPoint) { // joinPoint 連接點 -> 進行縫合
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("前置通知:" + methodName + "," + Arrays.toString(args));
	}

	@After(value = "point()")
	public void afterAdvice(JoinPoint joinPoint) { // 後置通知 Advice: 執行在連接點呼叫完之後, 在 SpringAOP 機制上會被配置在 finally 區段中
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("後置通知:" + methodName + "," + Arrays.toString(args));
	}

	@AfterReturning(value = "point()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) { // 後置通知 Advice: 執行在連接點呼叫完之後, 在 SpringAOP
																			// 機制上會被配置在 finally 區段中
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("結果通知:" + methodName + ",result=" + result + "," + Arrays.toString(args));
	}

	@AfterThrowing(value = "point()", throwing = "ex1")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable ex1) { // 後置通知 Advice: 執行在連接點呼叫完之後, 在 SpringAOP
																			// 機制上會被配置在 finally 區段中
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("錯誤通知:" + methodName + ",exception=" + ex1 + "," + Arrays.toString(args));
	}

	// 環繞通知
	// 注意: 啟用環繞通知前, 建議先將其他通知關閉
	@Around(value = "point()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		try {
			// 1. 前置通知
			System.out.printf("環繞通知: 前置通知 - 方法名稱: %s 參數: %s\n", methodName, Arrays.toString(args));
			// 2. 執行業務邏輯 (重要!! 一定要加入)
			result = joinPoint.proceed();
			// 3. 返回通知
			System.out.printf("環繞通知: 返回通知 - 方法名稱: %s 返回值: %s\n", methodName, result);
		} catch (Throwable e) {
			// 4. 異常通知
			System.out.printf("環繞通知: 異常通知 - 方法名稱: %s 例外: %s\n", methodName, result);
		} finally {
			// 5. 後置通知
			System.out.printf("環繞通知: 後置通知 - 方法名稱: %s\n", methodName);
		}
		return result;
	}

}
