package cn.annotation_aop.dao;

import java.util.List;

import cn.annotation_aop.domain.User;

public interface UserDAO {
     int insertUser(User user);//�����û�
     int updateUser(User user);//�޸��û�
     int deleteUser(int id);//ɾ���û�
     User selectUserById(int id);//ͨ��id��ѯ�û�
     List<User> selectAllUser();//��ѯ�����û�
}
