package com.niit.anno;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class User {
	int id;
	String name;
	String psd;
	//ʹ��@Autowirdeע���@Qualifierע��ʱ�䰴Beanʵ����װ��
	@Qualifier("random")
	@Autowired
	Random rnd;
	public User() {
	
	}
	@PostConstruct   //ָ����ʼ�����÷���
	public void initUser() {
		this.id=rnd.nextInt(1000);
		this.name="�û�"+this.id;
		this.psd="123";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public Random getRnd() {
		return rnd;
	}
	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}
	

}
