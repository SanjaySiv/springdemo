package com.samples;

public class ThrowExample {
	public static void validate(int age) {
		if(age<18)
			throw new ArithmeticException("not valid");
	}
	public static void main(String[] args) {
		validate(13);
		System.out.println("rest of the code...");  
	}
}