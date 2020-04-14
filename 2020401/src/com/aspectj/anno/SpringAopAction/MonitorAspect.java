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

    //�е㣬��UserDaoImpl�µ����з���
    @Pointcut("execution(* com.aspectj.anno.dao.UserDaoImpl.*(..))")
    public void pc(){

    }

    //����
    @Around("execution(* com.aspectj.anno.dao.UserDaoImpl.*(..))")
    public void monitorAround(ProceedingJoinPoint pjp) throws Throwable {
        //����ִ��ǰ
        long beginTime = System.currentTimeMillis();


        pjp.proceed(); //�൱��UserDaoImpl��ʵ��ִ�еķ���

        //����ִ�к�
        long endTime = System.currentTimeMillis();
   
        MonitorTime monitorTime = new MonitorTime();
        monitorTime.setComsumeTime(endTime-beginTime);
        monitorTime.setClassName(pjp.getTarget().getClass().getName());
        monitorTime.setMethodName(pjp.getSignature().getName());

        new MonitorUtils().report(monitorTime);

        /*
        //����÷���ִ�е�ʱ��
        logger.info("total cost time: "+(endTime-beginTime));

        //��ȡ��װ��������Ϣ�Ķ����ڸö����п��Ի�ȡ��Ŀ�귽�������������class����Ϣ
        Signature signature = pjp.getSignature();
        logger.info("Ŀ�귽������"+signature.getName());

        //��ȡ������Ķ���
        logger.info("������Ķ���"+pjp.getTarget());

        //��ȡ��������������
        logger.info("����������������"+pjp.getTarget().getClass().getName());

        //��ȡĿ�귽��������ļ�����
        logger.info("Ŀ�귽��������ļ�������"+signature.getDeclaringType().getSimpleName());

        //��ȡĿ�귽�������������
        logger.info("Ŀ�귽���������������"+signature.getDeclaringTypeName());
        */

    }


}
