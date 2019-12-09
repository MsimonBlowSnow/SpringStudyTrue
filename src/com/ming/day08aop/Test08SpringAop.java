package com.ming.day08aop;

import javax.annotation.Resource;

import org.junit.Test;
/*import org.junit.Test;*/
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/ming/day08aop/ApplicationContext08.xml")
public class Test08SpringAop {
	//将名为user的对象注入到us变量里面
	@Resource(name = "userService")
	private Day08UserService user;
	@Resource(name = "userServiceCglib")
	private Day08UserServiceImpl02 userCglib;
	@Test
	public void Test08SpringAop01() {
		//ApplicationContext ap= new ClassPathXmlApplicationContext("com/ming/day08aop/ApplicationContext08.xml");
		//user = (Day08UserService) ap.getBean("userService");
		//动态代理
		user.delete();
		user.save();
		user.select();
		user.update();
		//cglib代理
		userCglib.sayhello();
	}
}
