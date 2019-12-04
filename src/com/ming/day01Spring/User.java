package com.ming.day01Spring;

public class User {
	static {
		System.out.println("¾²Ì¬´úÂë¿é");
	}
	private String nameString;
	private int age;
	@Override
	public String toString() {
		return "User [age=" + age + ", nameString=" + nameString + "]";
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
