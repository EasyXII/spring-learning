package com.aspectj.anno.SpringAopAction;
/**
 * �쳣���������
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
    	   //�쳣���¼
    	   info.setClassName(joinPoint.getTarget().getClass().getName());
    	   info.setMethodName(joinPoint.getSignature().getName());
    	   info.setLogTime(new Date());
    	   info.setMessage(e.toString());
    	   //�ϴ���־ϵͳ
    	   ExceptionReportUtils.report(info);
    	   
       }
}
