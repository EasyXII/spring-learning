package cn.annotation_aop.dao;

import cn.annotation_aop.domain.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")//将本类标注为一个DAO组件
public class UserDAOImpl implements UserDAO{

	@Override
	public int insertUser(User user) {
		System.out.println("添加用户"+user.getAccount());
		return 1;
	}

}
