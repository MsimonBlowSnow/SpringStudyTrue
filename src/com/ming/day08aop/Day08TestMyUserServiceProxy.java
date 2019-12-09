package com.ming.day08aop;

import org.junit.Test;

public class Day08TestMyUserServiceProxy {
	
	//@Test
	public void test08MyUserServiceProxy() { // 创建对象 
		UserServiceImpl uServiceImpl = new UserServiceImpl(); // 创建动态代理工厂 
		Day08MyUserserviceProxy day08MyProxy = new Day08MyUserserviceProxy(uServiceImpl); // 使用动态代理工厂返回动态代理对象
		Day08UserService myProxyObject = day08MyProxy.getUserService(); // 调用动态代理的方法
		myProxyObject.save();

	}
	 

	@Test
	public void test08MyCglibProxy() {
		// cglib代理
		// 创建cglib代理工厂
		UserServiceImpl uServiceImpl = new UserServiceImpl(); // 创建动态代理工厂 
		Day08MyUserServiceProxyCglib proxyCglib = new Day08MyUserServiceProxyCglib();
		// 使用cglib工厂代理返回cglib代理的对象
		Day08UserService myCglibProxy = proxyCglib.getUserService();
		UserServiceImpl myCglibProxy01 = (UserServiceImpl) proxyCglib.getUserService();
		myCglibProxy.save();
		myCglibProxy01.save();
	}
}
