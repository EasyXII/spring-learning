package com.huodong3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath = "com/huodong3/beans.xml";
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
      Student student = (Student) applicationContext.getBean("student");
     // Student student2 = (Student) applicationContext.getBean("student2");
      System.out.println(student);
     // System.out.println(student2);
	}

}
