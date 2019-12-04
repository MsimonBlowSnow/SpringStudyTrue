package com.ming.day03Scope;

public class User03Scope {

	@Override
	public String toString() {
		return "User []"+this.hashCode();
	}
	public User03Scope() {
		System.out.println("User03Scope的空参构造");
	}
	public void init() {
		System.out.println("我是初始化方法");
	}
	public void destroy() {
		System.out.println("我是销毁方法");
	} 
}
