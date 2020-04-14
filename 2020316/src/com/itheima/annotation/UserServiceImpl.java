package com.itheima.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {
    // @Resource(name="userDao")
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save() {
		//调用userDao中的save()方法
	   this.userDao.save();
       System.out.println("userservice...save...");
	}

}
