package com.itheima.instance.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String xmlPath = "com/itheima/instance/factory/beans3.xml";
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
       System.out.println(applicationContext.getBean("bean3"));
	}

}
