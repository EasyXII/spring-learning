package com.aspectj.anno.SpringAopAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.aspectj.anno.dao.UserDaoImpl;


@Aspect
@Component
public class MonitorAspect {

    private Logger logger = LogManager.getLogger(UserDaoImpl.class);

    //切点，对UserDaoImpl下的所有方法
    @Pointcut("execution(* com.aspectj.anno.dao.UserDaoImpl.*(..))")
    public void pc(){

    }

    //环绕
    @Around("execution(* com.aspectj.anno.dao.UserDaoImpl.*(..))")
    public void monitorAround(ProceedingJoinPoint pjp) throws Throwable {
        //方法执行前
        long beginTime = System.currentTimeMillis();


        pjp.proceed(); //相当于UserDaoImpl的实例执行的方法

        //方法执行后
        long endTime = System.currentTimeMillis();
   
        MonitorTime monitorTime = new MonitorTime();
        monitorTime.setComsumeTime(endTime-beginTime);
        monitorTime.setClassName(pjp.getTarget().getClass().getName());
        monitorTime.setMethodName(pjp.getSignature().getName());

        new MonitorUtils().report(monitorTime);

        /*
        //计算该方法执行的时间
        logger.info("total cost time: "+(endTime-beginTime));

        //获取封装了署名信息的对象，在该对象中可以获取到目标方法名，所属类的class等信息
        Signature signature = pjp.getSignature();
        logger.info("目标方法名："+signature.getName());

        //获取被代理的对象
        logger.info("被代理的对象："+pjp.getTarget());

        //获取被代理对象的类名
        logger.info("被代理对象的类名："+pjp.getTarget().getClass().getName());

        //获取目标方法所属类的简单类名
        logger.info("目标方法所属类的简单类名："+signature.getDeclaringType().getSimpleName());

        //获取目标方法所属类的类名
        logger.info("目标方法所属类的类名："+signature.getDeclaringTypeName());
        */

    }


}
