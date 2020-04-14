package com.aspectj.anno.SpringAopAction;
/**
 * 异常监测切面类
 */
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ExceptionMonitor {
       @Pointcut("execution(* com.aspectj.anno.dao.*.*(..))")
       void exceptionMethod() {
    	   
       }
       @AfterThrowing(value="exceptionMethod()",throwing="e")
       public void monitorMethod(JoinPoint joinPoint,Throwable e) {
    	   ExceptionInfo info = new ExceptionInfo();
    	   //异常类记录
    	   info.setClassName(joinPoint.getTarget().getClass().getName());
    	   info.setMethodName(joinPoint.getSignature().getName());
    	   info.setLogTime(new Date());
    	   info.setMessage(e.toString());
    	   //上传日志系统
    	   ExceptionReportUtils.report(info);
    	   
       }
}
