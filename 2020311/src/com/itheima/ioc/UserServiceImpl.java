package com.itheima.ioc;

public class UserServiceImpl implements UserService {
    //����UserDao����
	 private UserDao userDao;
	//���UserDao���Ե�setter����������ʵ������ע�� 
	 public void setUserDao(UserDao userDao) {
		 this.userDao = userDao;
	 }
	@Override
	//ʵ�ֽӿ��еķ���
	public void say() {
		//����userDao�е�say()��������ִ��������
		this.userDao.say();
		System.out.println("userService say hello World !!");
	}

 
}
