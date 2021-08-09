package com.samples;

public class TestExceptionPropagation {
	void m() {
		int a=50/0; //exception occurs
	}
	void n() {
		m();
	}
	void p() {
		try {
			n();
		}catch(Exception e) {
			System.out.println("Exception Handled"); //exception handled
		}
	}
	public static void main(String[] args) {
		TestExceptionPropagation obj=new TestExceptionPropagation();
		obj.p();
		System.out.println("normal flow...");  
	}

}
