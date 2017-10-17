package com.mlz.controllor;

public class Stu {
	public void test() {
		System.out.println("考试");
	}	
}

class Gun extends Stu{
	@Override
	public void test() {
		System.out.print("伪装学生去");
		super.test();
	}
}
