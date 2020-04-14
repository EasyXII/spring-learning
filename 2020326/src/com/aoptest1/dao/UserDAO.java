package com.aoptest1.dao;

public interface UserDAO {
   //添加用户
	public void addUser(String username,String password);
   //删除用户
	public void delUser(int id);
	
}
