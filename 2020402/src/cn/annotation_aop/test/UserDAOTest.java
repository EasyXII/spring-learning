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
@ExtendWith(SpringExtension.class)//��ָ����Ԫ���Ե����л���
@ContextConfiguration(locations= {"classpath:applicationContect.xml"})//ָ�������ļ�
class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    
	@Test
	void insertTest() {
		//���
		User user1 = new User("ax", "123");
		int n1 = userDAO.insertUser(user1);
		assertEquals(1,n1);
	}
	@Test
	void updateTest() {
		//�޸�
		User user2 = new User("����", "888", 1);
		int n2 = userDAO.updateUser(user2);
		assertEquals(1,n2);
	}
	@Test
	void deleteTest() {
		//ɾ��
		int n3 = userDAO.deleteUser(6);
		assertEquals(1,n3);
	}
    @Test
    void selectByIdTest() {
    	//ͨ��id��ѯ
    	User user = userDAO.selectUserById(1);
    	System.out.println(user.toString(user.getId(), user.getAccount(), user.getPassword()));
    }
    @Test
    void selectAllTest() {
    	//��ѯ����
    	List<User> user = userDAO.selectAllUser();
    	//ѭ�����
    	for (User user11 : user) {
			System.out.println(user11.toString(user11.getId(), user11.getAccount(), user11.getPassword()));
		}
    }
}
