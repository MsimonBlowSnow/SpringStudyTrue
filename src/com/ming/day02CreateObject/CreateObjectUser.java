package com.ming.day02CreateObject;

public class CreateObjectUser {
	static {
		System.out.println("CreateObjectUser��̬�����!");
	}
	public CreateObjectUser() {
		System.out.println("CreateObjectUser�ղ�������");
	}
	@Override
	public String toString() {
		return "CreateObjectUser [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
