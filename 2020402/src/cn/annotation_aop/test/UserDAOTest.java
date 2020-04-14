package cn.annotation_aop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cn.annotation_aop.dao.UserDAO;
import cn.annotation_aop.domain.User;
@ExtendWith(SpringExtension.class)//从指定单元测试的运行环境
@ContextConfiguration(locations= {"classpath:applicationContect.xml"})//指定配置文件
class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    
	@Test
	void insertTest() {
		//添加
		User user1 = new User("ax", "123");
		int n1 = userDAO.insertUser(user1);
		assertEquals(1,n1);
	}
	@Test
	void updateTest() {
		//修改
		User user2 = new User("张三", "888", 1);
		int n2 = userDAO.updateUser(user2);
		assertEquals(1,n2);
	}
	@Test
	void deleteTest() {
		//删除
		int n3 = userDAO.deleteUser(6);
		assertEquals(1,n3);
	}
    @Test
    void selectByIdTest() {
    	//通过id查询
    	User user = userDAO.selectUserById(1);
    	System.out.println(user.toString(user.getId(), user.getAccount(), user.getPassword()));
    }
    @Test
    void selectAllTest() {
    	//查询所有
    	List<User> user = userDAO.selectAllUser();
    	//循环输出
    	for (User user11 : user) {
			System.out.println(user11.toString(user11.getId(), user11.getAccount(), user11.getPassword()));
		}
    }
}
