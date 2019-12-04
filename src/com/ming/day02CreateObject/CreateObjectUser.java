package com.ming.day02CreateObject;

public class CreateObjectUser {
	static {
		System.out.println("CreateObjectUser静态代码块!");
	}
	public CreateObjectUser() {
		System.out.println("CreateObjectUser空参数构造");
	}
	@Override
	public String toString() {
		return "CreateObjectUser [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
