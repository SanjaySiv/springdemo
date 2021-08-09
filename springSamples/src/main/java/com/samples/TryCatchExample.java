package com.samples;

public class TryCatchExample {

	public static void main(String[] args) {
		try {
			int num=20/0;
		}
		catch(Exception e) {
			System.out.println("Divided by zero");
		}
		System.out.println("Rest of the code");
	}

}
