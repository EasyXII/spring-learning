package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aspectj.anno.SpringAopAction.MonitorAspect;



public class ExceptionReportUtils {
    private static Logger logger = LogManager.getLogger(MonitorAspect.class);

    public static void report(ExceptionInfo exceptionInfo){
        logger.info("异常监控："+
                exceptionInfo.getClassName()+"类的"+
                exceptionInfo.getMethodName()+"方法调用时发生了异常:"+
                exceptionInfo.getMessage());
    }
}

