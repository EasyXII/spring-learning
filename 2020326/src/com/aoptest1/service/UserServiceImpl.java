package com.aoptest1.service;

import com.aoptest1.dao.UserDAO;

public class UserServiceImpl implements UserService {
     //ʹ��UserDAO�ӿ�������һ������
	 //��Ϊ�����set��������������ע��
	UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
        userDAO.addUser(username, password);
	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
        userDAO.delUser(id);
        throw new RuntimeException("���������׳���һ����Ϣ��");
	}

}
