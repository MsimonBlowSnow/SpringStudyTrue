package com.ming.day01Spring;

import org.ietf.jgss.Oid;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	@Test
	public void test() {
		//1������������,·��Ϊ��·������src	
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
 		//2������Ҫ����
		User user = (User) ac.getBean("User");
		//��ӡUser
	System.out.println(user);
	}
}
