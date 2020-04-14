package com.aoptest1.service;

import com.aoptest1.dao.UserDAO;

public class UserServiceImpl implements UserService {
     //使用UserDAO接口声明了一个对象
	 //并为其添加set方法，用于依赖注入
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
        throw new RuntimeException("这是特意抛出的一场信息！");
	}

}
