package com.ming.day05Injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Day05SpringDI {
	//spring的属性注入
	/*1.set方法注入
	 * 		数值类型的注入:
	 * 		<bean name="Userday05" class="">
    			<property name="nameString" value="Tomcat"></property>
    			<property name="age" value="19"></property>
    		</bean>
    		引用类的注入
    		
	 *2.构造函数注入
	 *3.p名称空间注入
	 *4.spel注入
	 * */
	@Test
	public void Test05() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/ming/day05Injection/Beanday05.xml");
		User05  user05 = (User05) aContext.getBean("Userday05");
		System.out.println("name:"+user05.getNameString()+",age:"+user05.getAge());
	}
}
