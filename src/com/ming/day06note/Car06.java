package com.ming.day06note;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component("car061")
public class Car06 {
	public void Init() {}
	@Value("red")
	private String colorString;
	@Value("11路公交车")
	private String branchString;
	public String getColorString() {
		return colorString;
	}
	public void setColorString(String colorString) {
		this.colorString = colorString;
	}
	public String getBranchString() {
		return branchString;
	}
	public void setBranchString(String branchString) {
		this.branchString = branchString;
	}
	@Override
	public String toString() {
		return "Car06 [colorString=" + colorString + ", branchString=" + branchString + "]";
	}
}
