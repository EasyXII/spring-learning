package cycle;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cycle/applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");
        student.play();
        System.out.println(student);
         ((AbstractApplicationContext) applicationContext).close();
	}

}
