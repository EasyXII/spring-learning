package cn.pb.dao.impl;

import cn.pb.dao.Animal;
//Ŀ����
public class Cat implements Animal {

	@Override
	public void eat() {
		System.out.println("èè�ڳ��㣡");
		
	}

	@Override
	public void sleep() {
		System.out.println("èè�����ݣ�");
		
	}

}
