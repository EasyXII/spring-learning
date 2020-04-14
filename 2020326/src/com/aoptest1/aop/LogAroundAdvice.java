package com.aoptest1.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {
    
	private Logger logger=LogManager.getLogger(LogAroundAdvice.class);
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		long beginTime=System.currentTimeMillis();
		invocation.proceed();
		long endTime=System.currentTimeMillis();
		//��ȡ�����õķ�����
		String targetMethodName = invocation.getMethod().getName();
		//��־��ʽ�ַ���
		String logInfoText = "����֪ͨ��"+targetMethodName+"��������ǰʱ��"+beginTime+"���룬"+"���ú�ʱ��"+endTime+"����";
		//����־��Ϣд�����õ��ļ���
		logger.info(logInfoText);
		return null;
	}

}
