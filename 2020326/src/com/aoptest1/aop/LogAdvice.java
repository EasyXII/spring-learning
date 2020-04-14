package com.aoptest1.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogAdvice implements MethodBeforeAdvice {
	private Logger logger=LogManager.getLogger(LogAdvice.class);
	@Override
	public void before(Method target, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		//��ȡ�����õķ�����
	   String targetMethodName = target.getName();
	    //��ȡ�����õ�����
	   String targetClassName = target.getClass().getName(); 
		//��־��ʽ�ַ���	 
       String logInfoText = "ǰ��֪ͨ��"+targetClassName+"���"+targetMethodName+"������ʼִ��";
       logger.info(logInfoText);
	}

}
