package com.ming.day05Injection;

public class User05 {
	private String nameString;
	private int age;
	private Car05 car05;
	public Car05 getCar05() {
		return car05;
	}
	
	public User05() {
		super();
	}

	public User05(int age, String nameString,Car05 car05) {
		super();
		System.out.println("User05构造函数注入");
		this.nameString = nameString;
		this.age = age;
		this.car05 = car05;
	}
	public void setCar05(Car05 car05) {
		this.car05 = car05;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	@Override
	public String toString() {
		return "User05 [nameString=" + nameString + ", age=" + age + ", car05=" + car05 + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
