package com.ming.day07JunitAndSpring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ming.day05Injection.User05;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/ming/day05Injection/Beanday05.xml")
public class Day07JunitAndSpring {
	//junit测试
		/*1.导包
		 * 		4+2+aop+test $(core,bean,context,expression)
		 * 2.注解(测试类上)
		 * 		//(有@Test的测试类上使用)帮我们创建容器
		 * 		@RunWith("SpringJunit4ClassRunner.class") 
		 * 		//指定位置，写在(有@Test的测试类上使用)
		 * 		@contexConfiguration("classpath:applicationContext.xml")
		 * 第一个的注解根据第二个注解的类路径获取容器并创建
		 * 		在本类(有@Test的测试类上使用)里面创建私有对象，你要获取的对象
		 * 	例如:本类就是一个方法
		 * */
	@Resource(name="Userday05")
	private User05 user;
	@Test
	public void method() {
		System.out.println(user);
	}
}
