package com.aspectj.anno.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.aspectj.anno.dao.UserDao;


public class MyTest {

    @Test
    public void myTest(){
        String xmlPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        UserDao userDao =(UserDao) context.getBean("userDao");

        userDao.addUser();

        userDao.deleteUser();
    }

}
