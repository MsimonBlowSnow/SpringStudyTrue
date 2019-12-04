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
	 * �ӿ�����ԭʼ�Ľӿڣ��ýӿڵ�ʵ���࣬���ܱȽϵ�һ
	*BeanFactory�ӿ�ʵ���������ص���ÿ�λ�ö���ʱ�Żᴴ������
	*	ʡ�ڴ�(�Ѿ���ʱ��)
	**/
	/*ApplicationContext
	 * 	������һ�д����аѶ��󶼴�����
	 *	ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 	
	 *  ÿ������������ʱ�ͻᴴ�����õ����ж���
	 *  ���·��:�����·���¼��������ļ�:ClassPathXmlApplicationContext(ʵ����)
	 *  ����·��:��Ӳ���ϼ��������ļ�:FileSystemXmlApplicationContext(ʵ����)
	 * */
	
	/*�ܽ�:
	 * 	��web������ʹ��applicationContext,��Դ�ѷ��������ʹ��BeanFactory(�ֻ���)
	 * 
	 * */
	@Test
	public void applicationTest() {

		//BeanFactory�ڻ�ȡbean�Ķ����ʱ�򴴽��ö���
		//�öδ������Ϊ1 ��̬����飬
		/*Resource res = new ClassPathResource("ApplicationContext.xml");
		BeanFactory bf=new XmlBeanFactory(res);
		System.out.println("1");
		//��ȡbean�Ķ����ʱ�򴴽��ö���
		User user= (User)bf.getBean("User");
		*/
		
		
		//�������̬����飬��Ϊapplicationÿ������������ʱ�ͻᴴ�����õ����ж���,��������ͻ�ִ�о�̬�����
		//�öδ������Ϊ��̬����� 1,
		/*
		  ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		  //���������̬����飬�Ѿ�ִ����һ��
		   System.out.println("1");
		  ApplicationContext ac1 = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		  //ÿ��1��2User���󶼲�ͬ��2��3������ͬ System.out.println(ac.getBean("User").hashCode());
		  System.out.println(ac1.getBean("User").hashCode());
		  System.out.println(ac1.getBean("User").hashCode());
		 */
	}
}
