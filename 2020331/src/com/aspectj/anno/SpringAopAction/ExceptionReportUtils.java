package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionReportUtils {
     private static Logger logger = LogManager.getLogger(TimerAspect.class);
     
     public static void report(ExceptionInfo info) {
    	 logger.info("异常监控："+info.getClassName()+"类的"+info.getMethodName()+"方法调用时发生了异常："+info.getMessage());
     }
}
