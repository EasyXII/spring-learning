package cn.annotation_aop.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.annotation_aop.dao.UserDAO;
import cn.annotation_aop.domain.User;
//������
public class TestAnnotationAspectj {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//1��spring�����������
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao");
        //2ִ�з���
		userDAO.insertUser(new User("AX", "123"));
	}

}
