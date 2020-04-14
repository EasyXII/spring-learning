package cn.pb.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.pb.aspect.MyAspect.MyAspect;
//������
public class AnimalCglibDynamicProxy implements MethodInterceptor {
    //������
	public Object createProxy(Object target) {
		//����һ����̬�����
		Enhancer enhancer = new Enhancer();
		//ȷ����Ҫ��ǿ���࣬�����丸��
		enhancer.setSuperclass(target.getClass());
		//��ӻص�����
		enhancer.setCallback(this);
		//���ش����Ĵ�����
		return enhancer.create();
	}
	/**
     * proxy CGlib����ָ���������ɵĴ������
     * method ���صķ���
     * args ���صķ����Ĳ�������
     * methodProxy �����Ĵ����������ִ�и���ķ���
     */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		//�����������
		MyAspect myAspect = new MyAspect();
		//ǰ��ǿ
		myAspect.before();
		//Ŀ�귽��ִ��
		Object object = methodProxy.invokeSuper(proxy, args);
		//����ǿ
		myAspect.next();
		return object;
	}

}
