package com.aoptest1.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogAdvice implements ThrowsAdvice {
         private Logger logger = LogManager.getLogger(ThrowsLogAdvice.class);
         public void afterThrowing(Method method, Object[] args, Object target, Throwable exeptionClass) {
        	//��ȡ�����õķ�����
  		   String targetMethodName = method.getName();
  		    //��ȡ�����õ�����
  		   String targetClassName = method.getClass().getName(); 
  			//��־��ʽ�ַ���	 
  	       String logInfoText = "�쳣֪ͨ��"+targetClassName+"���"+targetMethodName+"������ʼִ��";
  	       logger.info(logInfoText);
         }
}
