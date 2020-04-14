package cn.pb.dao.impl;

import cn.pb.dao.Animal;

public class TestProxy {

	public static void main(String[] args) {
		//�����������
		AnimaljdkDynamicProxy animaljdkDynamicProxy = new AnimaljdkDynamicProxy();
		//����Ŀ�����
		Animal animal = new Cat();
		//�Ӵ�������л�ȡ��ǿ���Ŀ�����
		Animal animal1 = (Animal) animaljdkDynamicProxy.createProxy(animal);
		animal1.eat();
		System.out.println("******************");
		animal1.sleep();
	} 

}
