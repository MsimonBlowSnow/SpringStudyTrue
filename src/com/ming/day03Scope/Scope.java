package com.ming.day03Scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Scope {
	/*scope属性的取值:
	 *1.singleton(默认) 被表示为singleton的对象在容器里面只有一份实例 
	 * 启动application时会创建
	 * <bean name="User03ScopeSingleton" class="com.ming.day03Scope.User03Scope"></bean>
	 * 2.prototype:
	 * 获得bean时才会创建
	 * <bean name="User03ScopePrototype" class="com.ming.day03Scope.User03Scope" scope="prototype"></bean>
	 * 3.request:在web环境下，与request生命周期一致
	 * 4.session:在web环境下，与session对象生命周期一致
	 * 5.生命周期属性,可以配置生命周期初始化方法和销毁方法
	 * 配置一个方法作为生命周期的销毁方法spring容器在关闭并销毁所有容器中的对象之前调用
	 * 初始化方法:init-method
	 * 销毁方法:destory-method
	 * 	<bean name="User03InitDestroy" class="com.ming.day03Scope.User03Scope" init-method="init" destroy-method="destroy"></bean>
	 * */
	@Test
	public void test03Scope() {
		//单例时(默认singleton):输出构造函数先在输出数字，启动时创建
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//两者hashcode一样，是同一个对象，默认的scope为singleton
		System.out.println(1);
		System.out.println(ac.getBean("User03ScopeSingleton"));
		System.out.println(ac.getBean("User03ScopeSingleton"));
		//两者hashcode不同,是不同的对象，scope的值为prototype
		//多利时(prototype:)先输出数字，在输出2次构造函数，获取bean时创建
		System.out.println(1);
		System.out.println(ac.getBean("User03ScopePrototype"));
		System.out.println(ac.getBean("User03ScopePrototype"));
		//使用ClassPathXmlApplicationContext的参数，不使用接口参数，原因是因为接口ApplicationContext中没有close()方法
		ac.close();
	}
}	
