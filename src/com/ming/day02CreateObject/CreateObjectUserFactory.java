package com.ming.day02CreateObject;

public class CreateObjectUserFactory {
	public static CreateObjectUser createUser() {
		System.out.println("��̬��������CreateObjectUser");
		return new CreateObjectUser();
	}
	public CreateObjectUser createUser1() {
		System.out.println("ʵ����������CreateObjectUser");
		return new CreateObjectUser();
	}
}
