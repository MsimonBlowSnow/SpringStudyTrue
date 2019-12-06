package com.ming.day05Injection;

public class Car05 {
	private String color;
	private String branch;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Car05 [color=" + color + ", branch=" + branch + "]";
	}
	
	public Car05() {
		super();
	}
	public Car05(String color, String branch) {
		super();
		System.out.println("car05构造函数的注入!");
		this.color = color;
		this.branch = branch;
	}
	
}
