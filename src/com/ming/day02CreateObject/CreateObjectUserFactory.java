package com.ming.day02CreateObject;

public class CreateObjectUserFactory {
	public static CreateObjectUser createUser() {
		System.out.println("静态工厂创建CreateObjectUser");
		return new CreateObjectUser();
	}
	public CreateObjectUser createUser1() {
		System.out.println("实例工厂创建CreateObjectUser");
		return new CreateObjectUser();
	}
}
