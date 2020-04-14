package cn.annotation_aop.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.annotation_aop.dao.UserDAO;
import cn.annotation_aop.domain.User;
//测试类
public class TestAnnotationAspectj {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//1从spring容器获得内容
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao");
        //2执行方法
		userDAO.insertUser(new User("AX", "123"));
	}

}
