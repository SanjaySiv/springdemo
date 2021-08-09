package com.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Drawing {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_mvctesting.xml");  
		Triangle triangle=(Triangle)((BeanFactory) context).getBean("triangle");  
		triangle.draw();
	}
	
}
