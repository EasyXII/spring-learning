package com.aoptest1.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogAdvice implements AfterReturningAdvice {
	private Logger logger=LogManager.getLogger(AfterLogAdvice.class);
	@Override
	public void afterReturning(Object arg0, Method target, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		//��ȡ�����õķ�����
		   String targetMethodName = target.getName();
		    //��ȡ�����õ�����
		   String targetClassName = target.getClass().getName(); 
			//��־��ʽ�ַ���	 
	       String logInfoText = "����֪ͨ��"+targetClassName+"���"+targetMethodName+"������ʼִ��";
	       logger.info(logInfoText);
	}

}
