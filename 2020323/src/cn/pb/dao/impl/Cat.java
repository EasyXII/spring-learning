package cn.pb.dao.impl;

import cn.pb.dao.Animal;
//目标类
public class Cat implements Animal {

	@Override
	public void eat() {
		System.out.println("猫猫在吃鱼！");
		
	}

	@Override
	public void sleep() {
		System.out.println("猫猫在午休！");
		
	}

}
