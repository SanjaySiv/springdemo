package com.samples;

public class FinallyBlockExample {

	public static void main(String[] args) {
		try {
			int a=25/0;
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("finally block executed");
		}
		System.out.println("rest of the code");  
	}
}
