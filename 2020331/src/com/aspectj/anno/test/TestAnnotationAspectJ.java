package com.aspectj.anno.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aspectj.anno.dao.UserDao;
@ExtendWith(SpringExtension.class)//ָ����Ԫ���Ե����л���
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})//ָ�������ļ�·��
class TestAnnotationAspectJ {
    @Autowired//�Զ�����ע���е�UserDao��ʵ��userDao
    private UserDao userDao;
	@Test
	void test() {
		userDao.addUser();
		userDao.deleteUser();
	}

}