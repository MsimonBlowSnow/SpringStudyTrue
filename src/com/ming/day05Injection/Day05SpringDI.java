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
    		引用类的注入:
    <bean name="Userday05" class="com.ming.day05Injection.User05">
    	<property name="nameString" value="Tomcat"></property>
    	<property name="age" value="19"></property>
    	//引用对象的注入:
    	<property name="car05" ref="car05"></property>
    </bean>
    <bean name="car05" class="com.ming.day05Injection.Car05">
    	<property name="color" value="red"></property>
    	<property name="branch" value="11路公交车"></property>
    </bean>
    		
	 *2.构造函数注入
	 *name: 构造函数的参数名
	 *index :构造函数的索引
	 *type属性构造函数的类性，如import
	 *
    	<constructor-arg name="car05" ref="Car05Con" type="com.ming.day05Injection.Car05"></constructor-arg>
	 *<bean name="Car05Con" class="com.ming.day05Injection.Car05">
    	<constructor-arg name="color" value="red" index="0" type="java.lang.String"></constructor-arg>
    	<constructor-arg name="branch" value="自行车" index="1"></constructor-arg>
    </bean>

	 *	
	 *3.p名称空间注入
	 *	在xml配置中粘贴
	 *		xmlns:p="http://www.springframework.org/schema/p"
	 *		<bean name="User3" class=""></bean>
	 *
    	<!-- p命名空间注入-->
    	p:name="XXX" p:Car05="XXX";
    	<bean name="User05P" class="com.ming.day05Injection.User05" p:age="18" p:car05-ref="CarP" p:nameString="ming"></bean>
    	<bean name="CarP" class="com.ming.day05Injection.Car05">
    		<property name="color" value="red"></property>
    		<property name="branch" value="马车"></property>
    	</bean>
    	
	 *4.spel注入:spring Expression Language Sping表达式语言
	 *spel注入使用#{}完成注入，其中#{User05Con.nameString}其中User05Con为另一个javabean	
	 *<bean name="UserSpel" class="com.ming.day05Injection.User05">
    		<property name="car05" ref="CarP"></property>
    		<property name="nameString" value="#{User05Con.nameString}"></property>
    	<property name="age" value="#{User05Con.age}"></property>
    </bean>		
	 *
	 * */
	
	/*复杂类型注入:
	 * 	1.数组
	 * 		<!-- array注入 -->
    	<bean name="arrayInjectionOne" class="com.ming.day05Injection.Day05ComplexInjection">
    		<!--如果数组中只有一个值，直接使用ref|value即可-->
    		<property name="arr" value="tom"></property>
    	</bean>
    	<bean name="arrayInjectionMany" class="com.ming.day05Injection.Day05ComplexInjection">
    		<!-- 如果有多个值 -->
    		<property name="arr">
    			<array>
    				<value>张三</value>
    				<value>李四</value>
    				<value>王二</value>
    				<value>麻子</value>
    				<ref bean="UserSpel"/>
    			</array>
    		</property>
    	</bean>
	 * 2.List注入:
	 * 	<!-- list注入 -->
    		<!-- 如果list只有一个值 -->
    		<bean name="ListInJectionOne" class="com.ming.day05Injection.Day05ComplexInjection">
				<!-- 如果list只有一个值,使用value|ref注入-->	
				<property name="list" value="mmp"></property>    		
    		</bean>
    		<bean name="ListInJectionMany" class="com.ming.day05Injection.Day05ComplexInjection">
    			<!--list有多个值-->
    			<property name="list">
    				<list>
    					<value>mmp1</value>
    					<value>mmp2</value>
    					<value>mmp3</value>
    					<value>mmp4</value>
    					<ref bean="UserSpel"/>
    				</list>
    			</property>
    		</bean>
    		
	 * 3.map注入
	 * 	<!-- map注入 -->
    	<!-- map注入 -->
    		<bean name = "MapInJection" class="com.ming.day05Injection.Day05ComplexInjection">
    			<property name="map">
    				<map>
    					<entry key="张三" value = "mmp0"></entry>
    					<entry key="张三1" value = "mmp1"></entry>
    					//键为参数，值为对象
    					<entry key="user" value-ref= "UserSpel"></entry>
  						//键为对象，值为对象						
    					<entry key-ref="User05Con"  value-ref="Userday05"></entry>
    				</map>
    			</property>
    		</bean>
	 * 	
	 * 4.propotype注入
	 * 	
	 * 		<!--prototype注入-->
    		<bean name="PrototypeInJection" class="com.ming.day05Injection.Day05ComplexInjection">
    			<property name="prop">
    				<props>
    					<prop key="driverClass">com.ming.text</prop>
    					<prop key="userName">root</prop>
    					<prop key="password">123456</prop>
    				</props>
    			</property>
    		</bean>
	 * */
	
	@Test
	public void Test05() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/ming/day05Injection/Beanday05.xml");
		User05  user05 = (User05) aContext.getBean("Userday05");
		
		System.out.println("name:"+user05.getNameString()+",age:"+user05.getAge());
		//set方法注入
		System.out.println(user05);
		//构造方法注入
		System.out.println(aContext.getBean("User05Con"));
		//p命名空间注入
		System.out.println("P命名空间注入"+aContext.getBean("User05P"));
		//spel注入
		System.out.println(aContext.getBean("UserSpel"));
		
		
		/*复杂注入*/
		//数组单例注入
		System.out.println(aContext.getBean("arrayInjectionOne"));
		//数组多例注入
		System.out.println(aContext.getBean("arrayInjectionMany"));
		//list单例注入
		System.out.println(aContext.getBean("ListInJectionOne"));
		//list多例注入
		System.out.println(aContext.getBean("ListInJectionMany"));
		
		//Map
		System.out.println(aContext.getBean("MapInJection"));
		
		//propotyppe注入
		System.out.println(aContext.getBean("PrototypeInJection"));
	}
}
