package com.aoptest1.dao;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
        System.out.println(username+"用户添加成功！");
	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
        System.out.println("编号为"+id+"的用户被删除！");
	}

}
