package com.aoptest1.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aoptest1.service.UserService;

public class AOPTest {

	public static void main(String[] args) {
		//加载applicationContext.xml配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取配置中的UserServiceImpl实例
		UserService userService = (UserService) context.getBean("userProxy");
        userService.addUser("ax", "123123");
        userService.delUser(5);
	}

}
