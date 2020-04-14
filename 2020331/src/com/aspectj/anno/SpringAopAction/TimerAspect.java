package com.aspectj.anno.SpringAopAction;
/**
 * API�ӿ����ܷ���
 */
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class TimerAspect {
/*
 * �����е㺯��
 */
	@Pointcut("execution(* com.aspectj.anno.dao.*.*(..))")
	void timer() {
		
	}
	
	@Around("timer()")
	public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable{
		MonitorTime monitorTime = new MonitorTime();
		//��ȡĿ��������
		String clazzName = thisJoinPoint.getTarget().getClass().getName();
		//��ȡĿ���෽������
		String methodName = thisJoinPoint.getSignature().getName();
		
		monitorTime.setClassName(clazzName);//��¼������
		monitorTime.setMethodName(methodName);//��¼��Ӧ��������
		monitorTime.setLogTime(new Date());
		
		//��ʱ������Ŀ�꺯��
		long start = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		long time = System.currentTimeMillis() - start;
		
		//��������ʱ��
		monitorTime.setComsumeTime(time);
		MonitorUtils.report(monitorTime);
		return result;
	}
}
