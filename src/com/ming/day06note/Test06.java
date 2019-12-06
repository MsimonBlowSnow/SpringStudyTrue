package com.ming.day06note;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test06 {
	/*注解需要7个包，为 aop,core,context,context-support,beans,expression,commmons-log,
	 * 前五个要:六个包，不用aop*/
	
	/*1.使用注解配置spring
	 * 	步骤
	 * 		1.为主配置文件引入新的命名(约束)
	 * 			window->preferences->xml catalog，倒入spring的context-xsd
	 * 			配置bean: 创建bean->design->右键beans,
	 * 			Edit namespaces->add->spief new namespace->选择里面的spring的xsd，
	 * 			具体如图:1.png
	 * 		2.开启使用注解代替配置文件
	 * 			扫描时后扫描所有子孙包，不扫面上一级包
	 * 			自动扫描 base-package ="com.ming.day06note" 自动扫描com.ming.day06note下的所有的类
	 * 			<context:component-scan base-package="com.ming.day06note"></context:component-scan>
			3.注解的使用
				@Component("user06");(例如,User06的类里面)
				//该注解相当于配置了<bean name = "user06" class ="com.ming.day06mote.User06"
	*				
	*			@Service,@Controller,@Reposustory这个和@Component功能上没有任何区别，
	*			不过他们有特殊的意义
	*			@Service service层
	*			@Controller web层
	*			@Repository	dao层
	 * 			(推荐使用@Service,@Controller,@Reposustory三种)
	 * 		4.作用域
	 * 			使用方法:@Scope(scopeName = "prototype")
	 * 			1.singleton(单例默认)
	 * 			3.prototype (多例原型)
	 * 		5.属性注入
	 * 		(注意注解里面只有一个值，并且键是value的化可以忽略)
	 * 		如: @value(value="mmp") 可以改为 @value("mmp")	
	 * 		@value(User06)
	 * 		普通类型
	 * 				1.加在成员变量上:通过反射的field赋值直接对(破坏了封装性，方便看）
	 * 				2.加在set方法上:通过构造方法赋值(推荐使用，不过不方便看)
	 * 		引用类性:
	 * 		1.autowired	//自动装配(自动匹配容器里面满足规则的对象.)
	 * 					例:	@Autowired
							private Car06 car06;
							@Component("car")
							public class Car06 {
					问题:如果有多个对象满足要求，就不能选择(即只适用于容器里面只有一个满足要求的对象)
	 * 			问题解决:如果有多个对象可以加上一个
	 * 				@Qulifer("");
	 * 			多个对象的自动装配:
	 * 				User06类
	 * 					@Autowired
						@Qualifier("car061")
						private Car06 car06;
					Car06
						1.一个Car06对象
						@Component("car061")
						public class Car06 {
	 * 							@Value("red")
								private String colorString;
								@Value("11路公交车")
								private String branchString;
						}
						2.第二个Car06对象
							<bean name="car062" class="com.ming.day06note.Car06">
								<property name="colorString" value="black"></property>
								<property name="branchString" value="12路公交车"></property>
							</bean>
						效果:		  System.out.println(aContext.getBean("user06"));
								打印:User06 [car06=Car06 [colorString=red, branchString=11路公交车], name=tom, age=18]
					2.对象注入的方式:
								(推荐)@Resource(name="car")//直接注入指定的对象
								相当于是使用了
	 * 						@Autowired
							@Qualifier("car")				
							
	 */	
	/*	6使用注解指定初始化方法和销毁方法
	 * 		注意要导包，import javax.annotation.PostConstruct;
					 import javax.annotation.PreDestroy;
					1.8的jdk以上会把javax隐藏掉，自己输入并隐藏
	 * 
	 * */
	@Test
	public void test06() {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/ming/day06note/Beans06.xml");
		  User06 user06 = (User06) aContext.getBean("user06");
		  //测试作用域
		  System.out.println(user06.hashCode());
		  System.out.println(aContext.getBean("user06").hashCode());
		  //测试@value
		  System.out.println(aContext.getBean("user06"));
		  ((ClassPathXmlApplicationContext)aContext).close();
	}
}
