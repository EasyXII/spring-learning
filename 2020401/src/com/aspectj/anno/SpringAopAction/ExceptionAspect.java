package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.aspectj.anno.dao.UserDaoImpl;

@Aspect
@Component
public class ExceptionAspect {

    private Logger logger = LogManager.getLogger(UserDaoImpl.class);

    //切点，对UserDaoImpl下的所有方法
    @Pointcut("execution(* com.aspectj.anno.dao.UserDaoImpl.*(..))")
    public void pc(){

    }

    @AfterThrowing(pointcut = "pc()",throwing = "e")
    public void handleThrowing(JoinPoint jp, Exception e){
        ExceptionInfo info = new ExceptionInfo();

        //获取发生异常的类名
        String className = jp.getTarget().getClass().getName();
        //获取发生异常的方法
        String methodName = jp.getSignature().getName();
        //获取异常信息
        String message = e.getMessage();

        info.setClassName(className);
        info.setMethodName(methodName);
        info.setMessage(message);

        new ExceptionReportUtils().report(info);
    }

}
