package cn.pb.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.pb.aspect.MyAspect.MyAspect;
import cn.pb.dao.Animal;
//������
public class AnimaljdkDynamicProxy implements InvocationHandler{

	//����Ŀ����ӿ�
	private Animal animal;
	//����������
    public Object createProxy(Animal animal) {
    	this.animal = animal;
    	ClassLoader classLoader = AnimaljdkDynamicProxy.class.getClassLoader();
    	Class<?>[] classes = animal.getClass().getInterfaces();
    	return Proxy.newProxyInstance(classLoader, classes, this);
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//��������
		MyAspect myAspect = new MyAspect();
		//ǰ��ǿ
		myAspect.before();
		//��Ŀ�����ϵ��÷��������������
		Object object = method.invoke(animal, args);
		//����ǿ
		myAspect.next();
		return object;
	}
      
}
