package com.niit.anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class AnnotationIoCBean {
	@Resource //ע�����Կ���ʡ��setter����
	Date now;
	@Resource(name="simpleDateFormat")
	SimpleDateFormat sdf;
	User user1;
	@Autowired
	User user2;
	@Autowired
	User user3;
	@Resource
	public void setUser1(User user) {
		this.user1=user;
	}
	public AnnotationIoCBean() {
		
	}
	@PostConstruct
	public void init() {
		System.out.println("��AnnotationIOCBean��ʵ������");
		
	}
	@PreDestroy
	public void destory() {
		System.out.println("��AnnotationIOCBean��������");
	}
	public void execute() {
		System.out.println("����ʱ�䣺"+sdf.format(now));
		System.out.println("��һ���û���"+user1.getId());
		System.out.println("�ڶ����û���"+user2.getId());
		System.out.println("�������û���"+user3.getId());
	}

}
