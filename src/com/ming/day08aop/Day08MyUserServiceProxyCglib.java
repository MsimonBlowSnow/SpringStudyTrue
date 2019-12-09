package com.ming.day08aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Enhancer;

/*官方代码cglib代理(继承代理)
 * 
 * cglib要导包，不过由于spring中有cglib代理的包，已经倒入了Spring的包了
*/
public class Day08MyUserServiceProxyCglib implements MethodInterceptor{
	//用户调用这个函数会返回一个代理对象
	public Day08UserService getUserService() {
		//帮我们生成代理对相
		Enhancer en = new Enhancer();
		//告诉他继承代理对象的父类
		en.setSuperclass(UserServiceImpl.class);
		
		//参数为继承了cglib.MethodInterceptor的接口的类
		en.setCallback(this);
		//创建代理对象
		Day08UserService us =(Day08UserService) en.create();
		return us;
	}
	/*params
	 * 	第一个参数为代理的对象
	 * 	第二个参数为代理的对象函数
	 * 	第三个参数是代理对象的参数
	 * */
	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//代开事务
		System.out.println("cglib打开事务");
		//调用原有方法
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);
		//提交事务
		System.out.println("cglib提交事务");
		return returnValue;
	}
	
	
}