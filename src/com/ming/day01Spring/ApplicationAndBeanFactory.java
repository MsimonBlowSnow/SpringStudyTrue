package com.ming.day01Spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class ApplicationAndBeanFactory {
	/*BeanFactory:
	 * 接口是最原始的接口，该接口的实现类，功能比较单一
	*BeanFactory接口实现容器，特点是每次获得对象时才会创建对象
	*	省内存(已经过时了)
	**/
	/*ApplicationContext
	 * 	在下面一行代码中把对象都创建了
	 *	ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 	
	 *  每次容器的启动时就会创建配置的所有对象
	 *  相对路径:从类的路径下加载配置文件:ClassPathXmlApplicationContext(实现类)
	 *  绝对路径:从硬盘上加载配置文件:FileSystemXmlApplicationContext(实现类)
	 * */
	
	/*总结:
	 * 	在web开发中使用applicationContext,资源匮乏的情况日使用BeanFactory(手机端)
	 * 
	 * */
	@Test
	public void applicationTest() {

		//BeanFactory在获取bean的对象的时候创建该对象
		//该段代码输出为1 静态代码块，
		/*Resource res = new ClassPathResource("ApplicationContext.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		System.out.println("1");
		//获取bean的对象的时候创建该对象
		User user= (User)bf.getBean("User");
		*/
		
		
		//会输出静态代码块，因为application每次容器的启动时就会创建配置的所有对象,创建对象就会执行静态代码块
		//该段代码输出为静态代码块 1,
		/*
		  ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		  //不会输出静态代码块，已经执行了一次
		   System.out.println("1");
		  ApplicationContext ac1 = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		  //每个1，2User对象都不同，2，3对象相同 System.out.println(ac.getBean("User").hashCode());
		  System.out.println(ac1.getBean("User").hashCode());
		  System.out.println(ac1.getBean("User").hashCode());
		 */
	}
}
