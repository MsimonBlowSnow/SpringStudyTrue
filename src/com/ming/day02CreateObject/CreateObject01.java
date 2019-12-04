package com.ming.day02CreateObject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateObject01 {
	/*������ʽ1:�ղι���
	 * <bean id="CreateObjectUser" class="com.ming.day01CreateObject.CreateObjectUser"></bean>
	 * ������ʽ2:��̬������ʽ
	 * 	����com.ming.day01CreateObject.CreateObjectUserFactory��createUser����
	 * <bean id="CreateObjectUserFactory" class="com.ming.day01CreateObject.CreateObjectUserFactory" factory-method="createUser"></bean>
	 * ������ʽ3:ʵ������������ʽ����������û�о�̬��
	 * ����CreateObjectUserFactory�����CreateObjectUserFactory��������
	 * <bean id="CreateObjectUserFactoryStatic" factory-bean="CreateObjectUserFactory" factory-method="createUser1"></bean>
		<bean id="CreateObjectUserFactory" class="com.ming.day02CreateObject.CreateObjectUserFactory"></bean>
	 * */
	@Test
	public void testMehtod() {
		//applicationContext 
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//������ʽ1:�ղι���
		System.out.println(ac.getBean("CreateObjectUser"));
		//������ʽ2:��̬������ʽ
		System.out.println(ac.getBean("CreateObjectUserFactoryStatic"));
		//������ʽ3:ʵ��������ʽ
		System.out.println(ac.getBean("CreateObjectUserFactoryTrue"));
	}
}
