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
		//获取被调用的方法名
	   String targetMethodName = target.getName();
	    //获取被调用的类名
	   String targetClassName = target.getClass().getName(); 
		//日志格式字符串	 
       String logInfoText = "前置通知："+targetClassName+"类的"+targetMethodName+"方法开始执行";
       logger.info(logInfoText);
	}

}
