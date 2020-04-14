package com.aoptest1.aop;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogAdvice implements ThrowsAdvice {
         private Logger logger = LogManager.getLogger(ThrowsLogAdvice.class);
         public void afterThrowing(Method method, Object[] args, Object target, Throwable exeptionClass) {
        	//获取被调用的方法名
  		   String targetMethodName = method.getName();
  		    //获取被调用的类名
  		   String targetClassName = method.getClass().getName(); 
  			//日志格式字符串	 
  	       String logInfoText = "异常通知："+targetClassName+"类的"+targetMethodName+"方法开始执行";
  	       logger.info(logInfoText);
         }
}
