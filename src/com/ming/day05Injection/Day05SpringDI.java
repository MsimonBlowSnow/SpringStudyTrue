package com.ming.day05Injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Day05SpringDI {
	//spring������ע��
	/*1.set����ע��
	 * 		��ֵ���͵�ע��:
	 * 		<bean name="Userday05" class="">
    			<property name="nameString" value="Tomcat"></property>
    			<property name="age" value="19"></property>
    		</bean>
    		�������ע��
    		
	 *2.���캯��ע��
	 *3.p���ƿռ�ע��
	 *4.spelע��
	 * */
	@Test
	public void Test05() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/ming/day05Injection/Beanday05.xml");
		User05  user05 = (User05) aContext.getBean("Userday05");
		System.out.println("name:"+user05.getNameString()+",age:"+user05.getAge());
	}
}
