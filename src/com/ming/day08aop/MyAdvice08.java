package com.ming.day08aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice08 {
	/*1.前置通知->目标之前调用的
	 * 2.后置通知->(如果出现异常不会调用)目标方法运行之后调用
	 * 3.环绕通知->在目标方法之前和之后都调用
	 * 4.后置通知->(无论是否异常都会调用)目标方法之后调用
	 * 5.异常拦截通知->如果没出现异常，就会调用
	 * */
	
	//前制通知
	public void before() {
		System.out.println("这是前置通知");
	}
	
	//后置通知(出现异常不会调用)
	public void afterReturning() {
		System.out.println("这是后置通知");
	}
	
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知之前的部分!");
		//调用目标方法
		Object proceObject =pjp.proceed();
		System.out.println("这是环绕通知之后的部分!");
		return proceObject;
	}
	//异常通知
	public void afterException() {
		System.out.println("出现异常!");
	}
	//后值通知(出现异常也会调用)
	public void after() {
		System.out.println("后置通知(出现异常也会调用)!");
	}
}
