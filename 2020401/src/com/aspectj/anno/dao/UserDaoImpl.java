package com.aspectj.anno.dao;

import org.springframework.stereotype.Repository;
import com.aspectj.anno.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("����û�");
    }

    @Override
    public void deleteUser() {
        System.out.println("ɾ���û�");

        
    }
}
