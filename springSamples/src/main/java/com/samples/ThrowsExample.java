package com.samples;

import java.io.IOException;

class M{
	void method() throws IOException{
		throw new IOException("Device error");
	}
}
public class ThrowsExample {

	public static void main(String[] args) throws IOException {
		M m=new M();
		try {
		m.method();
		}catch(Exception e) {
			System.out.println(e);
		}
		 System.out.println("normal flow...");  
	}
}
