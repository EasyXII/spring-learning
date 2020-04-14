package cn.pb.dao.impl;

import cn.pb.dao.Animal;

public class TestProxy {

	public static void main(String[] args) {
		//创建代理对象
		AnimaljdkDynamicProxy animaljdkDynamicProxy = new AnimaljdkDynamicProxy();
		//创建目标对象
		Animal animal = new Cat();
		//从代理对象中获取增强后的目标对象
		Animal animal1 = (Animal) animaljdkDynamicProxy.createProxy(animal);
		animal1.eat();
		System.out.println("******************");
		animal1.sleep();
	} 

}
