package com.mlz.controllor;

public class Stu {
	public void test() {
		System.out.println("����");
	}	
}

class Gun extends Stu{
	@Override
	public void test() {
		System.out.print("αװѧ��ȥ");
		super.test();
	}
}
