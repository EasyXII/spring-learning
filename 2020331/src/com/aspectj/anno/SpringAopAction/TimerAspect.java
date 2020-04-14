package com.aspectj.anno.SpringAopAction;
/**
 * API接口性能分析
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
 * 定义切点函数
 */
	@Pointcut("execution(* com.aspectj.anno.dao.*.*(..))")
	void timer() {
		
	}
	
	@Around("timer()")
	public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable{
		MonitorTime monitorTime = new MonitorTime();
		//获取目标类名称
		String clazzName = thisJoinPoint.getTarget().getClass().getName();
		//获取目标类方法名称
		String methodName = thisJoinPoint.getSignature().getName();
		
		monitorTime.setClassName(clazzName);//记录类名称
		monitorTime.setMethodName(methodName);//记录对应方法名称
		monitorTime.setLogTime(new Date());
		
		//计时并调用目标函数
		long start = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		long time = System.currentTimeMillis() - start;
		
		//设置消耗时间
		monitorTime.setComsumeTime(time);
		MonitorUtils.report(monitorTime);
		return result;
	}
}
