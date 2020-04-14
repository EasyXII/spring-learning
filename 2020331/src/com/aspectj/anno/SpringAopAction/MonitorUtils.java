package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MonitorUtils {
    private static Logger logger = LogManager.getLogger(TimerAspect.class);
    
    public static void report(MonitorTime monitorTime) {
    	logger.info("API�ӿ����ܷ�����"+monitorTime.getMethodName()+"�������û�����"+monitorTime.getComsumeTime()+"����");
    }
}
