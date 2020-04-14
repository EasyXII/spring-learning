package cn.pb.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.pb.aspect.MyAspect.MyAspect;
import cn.pb.dao.Animal;
//代理类
public class AnimaljdkDynamicProxy implements InvocationHandler{

	//声明目标类接口
	private Animal animal;
	//创建代理方法
    public Object createProxy(Animal animal) {
    	this.animal = animal;
    	ClassLoader classLoader = AnimaljdkDynamicProxy.class.getClassLoader();
    	Class<?>[] classes = animal.getClass().getInterfaces();
    	return Proxy.newProxyInstance(classLoader, classes, this);
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//声明切面
		MyAspect myAspect = new MyAspect();
		//前增强
		myAspect.before();
		//在目标类上调用方法，并传入参数
		Object object = method.invoke(animal, args);
		//后增强
		myAspect.next();
		return object;
	}
      
}
