package com.itheima.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

	public static void main(String[] args) {
		//1.��ʼ��spring���������������ļ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans1.xml");
        //2.ͨ��������ȡUserServiceʵ��
		UserService userService = (UserService)applicationContext.getBean("userService");
		//3.����ʵ���е�say()����
		userService.say();
	}

}
