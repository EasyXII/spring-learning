package com.itheima.instance.static_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {

	public static void main(String[] args) {
		//���������ļ�·��
       String xmlPath = "com/itheima/instance/static_factory/beans2.xml";
       //Applicationcontext�ڼ��������ļ�ʱ����Bean����ʵ����
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
       System.out.println(applicationContext.getBean("bean2"));
	}

}