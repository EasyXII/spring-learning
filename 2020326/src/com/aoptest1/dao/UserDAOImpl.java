package com.aoptest1.dao;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
        System.out.println(username+"�û���ӳɹ���");
	}

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
        System.out.println("���Ϊ"+id+"���û���ɾ����");
	}

}
