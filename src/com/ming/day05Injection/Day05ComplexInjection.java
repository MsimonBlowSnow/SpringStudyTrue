package com.ming.day05Injection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Day05ComplexInjection {
	//该四个类性如何完成注入
	private Object[] arr;
	private List list;
	private Map map;
	private Properties prop;
	public Object[] getArr() {
		return arr;
	}
	public void setArr(Object[] arr) {
		this.arr = arr;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	@Override
	public String toString() {
		return "Day05ComplexInjection [arr=" + Arrays.toString(arr) + ", list=" + list + ", map=" + map + ", prop="
				+ prop + "]";
	}
	
}
