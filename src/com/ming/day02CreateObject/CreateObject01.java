package com.ming.day02CreateObject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateObject01 {
	/*创建方式1:空参构造
	 * <bean id="CreateObjectUser" class="com.ming.day01CreateObject.CreateObjectUser"></bean>
	 * 创建方式2:静态工厂方式
	 * 	调用com.ming.day01CreateObject.CreateObjectUserFactory的createUser方法
	 * <bean id="CreateObjectUserFactory" class="com.ming.day01CreateObject.CreateObjectUserFactory" factory-method="createUser"></bean>
	 * 创建方式3:实例工厂创建方式（工厂方法没有静态）
	 * 调用CreateObjectUserFactory对象的CreateObjectUserFactory创建对象
	 * <bean id="CreateObjectUserFactoryStatic" factory-bean="CreateObjectUserFactory" factory-method="createUser1"></bean>
		<bean id="CreateObjectUserFactory" class="com.ming.day02CreateObject.CreateObjectUserFactory"></bean>
	 * */
	@Test
	public void testMehtod() {
		//applicationContext 
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//创建方式1:空参构造
		System.out.println(ac.getBean("CreateObjectUser"));
		//创建方式2:静态工厂方式
		System.out.println(ac.getBean("CreateObjectUserFactoryStatic"));
		//创建方式3:实例工厂方式
		System.out.println(ac.getBean("CreateObjectUserFactoryTrue"));
	}
}
