package com.aspectj.anno.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aspectj.anno.dao.UserDao;
@ExtendWith(SpringExtension.class)//指定单元测试的运行环境
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})//指定配置文件路径
class TestAnnotationAspectJ {
    @Autowired//自动加载注释中的UserDao的实例userDao
    private UserDao userDao;
	@Test
	void test() {
		userDao.addUser();
		userDao.deleteUser();
	}

}
