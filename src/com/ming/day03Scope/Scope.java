package com.ming.day03Scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Scope {
	/*scope���Ե�ȡֵ:
	 *1.singleton(Ĭ��) ����ʾΪsingleton�Ķ�������������ֻ��һ��ʵ�� 
	 * ����applicationʱ�ᴴ��
	 * <bean name="User03ScopeSingleton" class="com.ming.day03Scope.User03Scope"></bean>
	 * 2.prototype:
	 * ���beanʱ�Żᴴ��
	 * <bean name="User03ScopePrototype" class="com.ming.day03Scope.User03Scope" scope="prototype"></bean>
	 * 3.request:��web�����£���request��������һ��
	 * 4.session:��web�����£���session������������һ��
	 * 5.������������,���������������ڳ�ʼ�����������ٷ���
	 * ����һ��������Ϊ�������ڵ����ٷ���spring�����ڹرղ��������������еĶ���֮ǰ����
	 * ��ʼ������:init-method
	 * ���ٷ���:destory-method
	 * 	<bean name="User03InitDestroy" class="com.ming.day03Scope.User03Scope" init-method="init" destroy-method="destroy"></bean>
	 * */
	@Test
	public void test03Scope() {
		//����ʱ(Ĭ��singleton):������캯������������֣�����ʱ����
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//����hashcodeһ������ͬһ������Ĭ�ϵ�scopeΪsingleton
		System.out.println(1);
		System.out.println(ac.getBean("User03ScopeSingleton"));
		System.out.println(ac.getBean("User03ScopeSingleton"));
		//����hashcode��ͬ,�ǲ�ͬ�Ķ���scope��ֵΪprototype
		//����ʱ(prototype:)��������֣������2�ι��캯������ȡbeanʱ����
		System.out.println(1);
		System.out.println(ac.getBean("User03ScopePrototype"));
		System.out.println(ac.getBean("User03ScopePrototype"));
		//ʹ��ClassPathXmlApplicationContext�Ĳ�������ʹ�ýӿڲ�����ԭ������Ϊ�ӿ�ApplicationContext��û��close()����
		ac.close();
	}
}	
