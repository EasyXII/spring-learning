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
		//获取被调用的方法名
		   String targetMethodName = target.getName();
		    //获取被调用的类名
		   String targetClassName = target.getClass().getName(); 
			//日志格式字符串	 
	       String logInfoText = "后置通知："+targetClassName+"类的"+targetMethodName+"方法开始执行";
	       logger.info(logInfoText);
	}

}
