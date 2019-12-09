package com.ming.day08aop;

public class UserServiceImpl implements Day08UserService{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("保存数据");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除数据");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新数据");
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("选择数据");
		//int i = 1/0;
	}

}
