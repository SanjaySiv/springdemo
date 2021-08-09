package com.samples;

public class NestedTryException {

	public static void main(String[] args) {
		try {
			try {
				System.out.println("Dividing");
				int b=14/0;
			}
			catch(ArithmeticException e) {
				System.out.println(e);
			}
			try {
				int[] a=new int[5];
				System.out.println(a[6]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println("handeled");
		}
		System.out.println("normal flow..");  
	}

}
