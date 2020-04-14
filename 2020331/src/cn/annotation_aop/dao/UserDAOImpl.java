package cn.annotation_aop.dao;

import cn.annotation_aop.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")//�������עΪһ��DAO���
public class UserDAOImpl implements UserDAO{

	@Override
	public int insertUser(User user) {
		System.out.println("����û�"+user.getAccount());
		return 1;
	}

}
