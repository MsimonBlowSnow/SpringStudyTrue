package com.ming.day03Scope;

public class User03Scope {

	@Override
	public String toString() {
		return "User []"+this.hashCode();
	}
	public User03Scope() {
		System.out.println("User03Scope�Ŀղι���");
	}
	public void init() {
		System.out.println("���ǳ�ʼ������");
	}
	public void destroy() {
		System.out.println("�������ٷ���");
	} 
}
