package com.mrprk.oops.multipleinheritance;

public class Test3 extends Test1 implements Test2 {

	int c;

	void test3() {
		System.out.println("This is test3 class method " + c);
	}

	@Override
	public void testTwo(int b) {
		System.out.println("This is test2 class method " + b);
	}

	public static void main(String[] args) {

		Test3 obj = new Test3();
		obj.a = 10;
		obj.c = 30;
		obj.testOne();
		obj.testTwo(b);
		obj.test3();
	}

}
