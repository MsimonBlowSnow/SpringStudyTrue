package com.ming.day01Spring;

import org.ietf.jgss.Oid;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	@Test
	public void test() {
		//1创建容器对象,路径为类路径，即src	
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
 		//2向容器要对象
		User user = (User) ac.getBean("User");
		//打印User
	System.out.println(user);
	}
}
