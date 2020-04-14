package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aspectj.anno.SpringAopAction.MonitorAspect;



public class ExceptionReportUtils {
    private static Logger logger = LogManager.getLogger(MonitorAspect.class);

    public static void report(ExceptionInfo exceptionInfo){
        logger.info("�쳣��أ�"+
                exceptionInfo.getClassName()+"���"+
                exceptionInfo.getMethodName()+"��������ʱ�������쳣:"+
                exceptionInfo.getMessage());
    }
}

