package com.ming.day06note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//该注解相当于配置了<bean name = "user06" class ="com.ming.day06mote.User06"
//@Scope(scopeName = "prototype")//指定对象的作用域,singleton单例时默认值，prototype时原型(多个)

//@Scope(scopeName = "singleton")
@Service("user06")
public class User06 {
	@Autowired
	//使用@Qualifier(“指定对象名”)确定对象名
	@Qualifier("car061")
	private Car06 car06;
	@Value("tom")
	private String name;
	@Value("18")
	private int age;
	public User06() {
		super();
	}
	public void setCar06(Car06 car06) {
		this.car06 = car06;
	}
	public String getName() {
		return name;
	}
	//@Value("tom")
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User06 [car06=" + car06 + ", name=" + name + ", age=" + age + "]";
	}
	 @PostConstruct//相当于初始化方法xml的init-method
	public void init() {
		System.out.println("初始化方法");
	}
	@PreDestroy	//相当于销毁方法xml里面的destroy-method
	public void destroy() {
		System.out.println("销毁方法");
	}
}
