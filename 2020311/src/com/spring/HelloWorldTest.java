package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    public static void main(String[] args) {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    	HelloWorld h = (HelloWorld)ac.getBean("hello");
    	h.sayHello();	
	}
}
