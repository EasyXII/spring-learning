package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionReportUtils {
     private static Logger logger = LogManager.getLogger(TimerAspect.class);
     
     public static void report(ExceptionInfo info) {
    	 logger.info("�쳣��أ�"+info.getClassName()+"���"+info.getMethodName()+"��������ʱ�������쳣��"+info.getMessage());
     }
}
