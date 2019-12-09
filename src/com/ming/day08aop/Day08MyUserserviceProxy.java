package com.ming.day08aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//官方代码动态代理(接口代理)

public class Day08MyUserserviceProxy implements InvocationHandler{
	private UserServiceImpl userServiceImpl;
	
	public Day08MyUserserviceProxy(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	//用户调用这个函数会返回一个代理对象
	public Day08UserService getUserService() {
		//生成代理对象
		/*params
		*  第一个参数为类的加载器,随便给一个:Day08MyUserserviceProxy.class.getClassLoader()
		*  第二个参数被代理对相的接口 :UserServiceImpl.class.getInterfaces()
		*  第三个参数:你要增强的功能，要实现InvocationHandler的类对象
		*/
		Day08UserService user= (Day08UserService) Proxy.newProxyInstance(Day08MyUserserviceProxy.class.getClassLoader(), 
								UserServiceImpl.class.getInterfaces(),
								this);
		return user;
		
	}
	/*params
	 * 
	 * 第一个参数:当前代理的对象
	 * 第二个参数:当前调用方法
	 * 当前方法执行的参数
	 * */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/*params
		 * 第一个参数:要产生代理对象的实例对象
		 * 第二个参数:执行函数的参数
		*/
		System.out.println("打开事务");
		Object invokeObject = method.invoke(userServiceImpl, args);
		System.out.println("提交事务");
		return invokeObject;
	}
}
