package com.samples;

import java.io.IOException;

public class ThrowsPropagationChecked {

	void m()throws IOException{  
	    throw new IOException("device error"); //checked exception
	}
	void n() throws IOException {
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
