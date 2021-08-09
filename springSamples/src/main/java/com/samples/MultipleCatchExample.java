package com.samples;

public class MultipleCatchExample {

	public static void main(String[] args) {
		try {
			int[] a=new int[5];
			a[4]=40/0;
			System.out.println(a[10]);
		}
		catch(ArithmeticException e) {
			System.out.println("ArithmeticExcepetion occurs");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException occurs");
		}
		catch(Exception e) {
			System.out.println("Parent exception");
		}
		System.out.println("rest of the code");
	}
}
