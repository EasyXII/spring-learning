package cn.annotation_aop.dao;

import java.util.List;

import cn.annotation_aop.domain.User;

public interface UserDAO {
     int insertUser(User user);//增加用户
     int updateUser(User user);//修改用户
     int deleteUser(int id);//删除用户
     User selectUserById(int id);//通过id查询用户
     List<User> selectAllUser();//查询所有用户
}
