package com.aoptest1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aoptest1.service.UserService;

public class AOPTest {

	public static void main(String[] args) {
		//����applicationContext.xml����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��ȡ�����е�UserServiceImplʵ��
		UserService userService = (UserService) context.getBean("userProxy");
        userService.addUser("ax", "123123");
        userService.delUser(5);
	}

}
