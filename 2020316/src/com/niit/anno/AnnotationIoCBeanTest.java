package com.niit.anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationIoCBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("com/niit/anno/beans.xml");
		AnnotationIoCBean annotationIoCBean=(AnnotationIoCBean)ac.getBean("annotationIoCBean");
				annotationIoCBean.execute();
				ac.close();

	}

}
