package com.ming.day08aop;

public class Day08Aop {
		/*	aop思想:
		 *    横向重复，纵向抽取 (如图1.png)
		 * 		例如:
		 * 			在web中所有的servlet里面全部都要设置编码，不过出现了filter，可以直接设置一个就可以了。
		 * 			这就是aop思想1.png
		 * */

			/*Spring的aop:
			 * 	Spring能够为容器中管理的对象生成动态代理对象
			 * 	Spring能帮我们生成代理对象
			 * 
			 * */
		/*spring 实现aop的原理:
		 * 	动态代理;(被代理对象必须要有接口,如果没有接口，就不能实现动态代理技术)
		 * 	cglib代理:(cglib，可以对任何类进行代理，代理的原理是对目标的对象进行继承代理)
		 * 			如果目标对象被final修饰，该类不能被cglib代理
		 * Spring混合了这两种代理:有接口使用动态代理，可以继承用cglib代理
		 * */
	//自己实现动态代理(不通过Spring)
		/*	代见Day08UserService,UserServier和Day08MyUserServiceProxy,Day08TestMyUserServiceProxy
		 * 	这三个类和接口实现动态代理(接口代理)	
		 * 
		 * 	代见Day08UserService,UserServier和Day08MyUserServiceProxyCglib,Day08TestMyUserServiceProxy
		 * 	这三个类和接口的实现了cglib代理(继承代理)
		 * */
	/*aop名词学习
	 * 	
	 * joinpoint(连接点):目标对象中可以增强的方法
	 * 		如:UserServiceImpl.java中的save(); select(); update();delete();
	 * Pointcut(切入点):目标对象，已经增强的方法
	 * 
	 * Advice(通知/增强):增强的代码
	 * 	在Day08MyUserserviceProxy中的Sysout.out.println();
	 * Target(目标对象):被代理的对象
	 * 
	 * Weaving(组织):将要通知织入切入点
	 * 
	 * Proxy(代理):将通知织入到目标对象之后，形成代理对象
	 * 
	 * aspect(切面):切人点+通知
	 */
	
	/*aop的具体步骤:
	 * 	1.导包4+2+2
	 * 		core,expression,context,beans,和aop和aspects
	 * 		aopalliance(不再spring框架内)
	 * 		aspectWeaver(不在spring框架内)
	 * 		2.png
	 * 	和一个日志文件如
	 * 2.准备目标对象
	 * 		Day08UserServiceImpl
	 * 3.准备通知(代码见MyAdvice08)
	 * 		  1.前置通知->目标之前调用的
	 * 		  2.后置通知->(如果出现异常不会调用)目标方法运行之后调用
	 *        3.环绕通知->在目标方法之前和之后都调用
	 * 		  4.后置通知->(无论是否异常都会调用)目标方法之后调用
	 *		  5.异常拦截通知->如果没出现异常，就会调用
	 * 
	 * 
	 * 4.配置进行织入,将通知织入目标
	 * 			aop配置:
	 * 		准备工作:倒入新的约束aop约束通过window->xml catalog倒入
	 * 		1.配置目标对象
	 * <!--1.配置目标对象 -->
			<bean name="userService" class="com.ming.day08aop.UserServiceImpl"></bean>
	
	 * 		2.配置通知对象
	 * 			<!-- 2,配置通知对象 -->
			<bean name="myAdvice" class="com.ming.day08aop.MyAdvice08"></bean>
	 * 		3.配置将通知织入目标对象
	 * 			<!--3.配置将通知织入目标对象 -->
	<aop:config>
		<!-- 配置切入点 固定格式:execution(public void 完整方法名) 完整方法名是指 包名+类名+方法 如: execution(public 
			void com.ming.day08aop.UserServiceImpl.save()) 注意: 一般格式: public void com.ming.day08aop.UserServiceImpl.save() 
			void com.ming.day08aop.UserServiceImpl.save() //一般默认public权限， * com.ming.day08aop.UserServiceImpl.save()用通佩服*表示返回值， 
			* com.ming.day08aop.UserServiceImpl.*() 用*表示一个类的所有的方法 * com.ming.day08aop.UserServiceImpl.*(..) 
			用..表示所有的参数 * com.ming.day08aop.*ServiceImpl.*(..) 用*表示dao08aop下的所有服务执行类 * 
			com.ming.day08aop..*ServiceImpl.*(..) 用*表示day08aop下所有的子包的所有以SericeImpl结尾的所有类 -->
		<aop:pointcut expression="execution(* com.ming.day08aop.UserServiceImpl.*(..))" id="pc" />
		<!-- 通知配置通知类 -->
		<aop:aspect ref="myAdvice">
			<!--指定名为before的方法作为前置通知 -->
			<aop:before method="before" pointcut-ref="pc" />
			<!-- 指定名为afterReturning方法配置后置通知(出现异常不会调用) -->
			<aop:after-returning method="afterReturning" pointcut-ref="pc" />
			<!-- 指定名为around方法配置环绕通知 -->
			<aop:around method="around" pointcut-ref="pc" />
			<!-- 配置环绕通知 -->
			<aop:after-throwing method="afterException" pointcut-ref="pc" />
			<!-- 指定名为after方法配置后置通知(出现异常会运行) -->
			<aop:after method="after" pointcut-ref="pc" />
		</aop:aspect>
	</aop:config>
	
		注意测试类应该使用的@Test时的导包
		import org.junit.Test;	//应该倒入的对象(推荐)
		import org.junit.jupiter.api.Test;	//倒入该包时,使用注解会出错，使用getbean不会出错
	 * */
}

