package com.niit.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)//指定单元测试的运行环境
@ContextConfiguration(locations= {"loginbeans.xml"})//指定配置文件路径
class usertest {

	@Autowired
    private User user;
	@Autowired
    private UserLogin userLogin;
	
	@Test
	void test() {
		boolean u=userLogin.userLogin(user);
		if(u==true) {
			System.out.println(user.toString());
		}else {
		    System.out.println("登录不成功");
		}
		//fail("Not yet implemented");
	}

}
