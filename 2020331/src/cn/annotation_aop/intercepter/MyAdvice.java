package cn.annotation_aop.intercepter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.annotation_aop.dao.UserDAOImpl;
/**
 * �Զ�����ǿ��
 */
@Aspect
@Component
public class MyAdvice {
     private final Logger logger = LogManager.getLogger(UserDAOImpl.class);
     
     //�е㣬��DAOImpl�����з���
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void pc() {
    	 
     }
     
     //ǰ����ǿ����ָ���е�
     @Before("MyAdvice.pc()")
     public void before() {
    	 logger.info("----�ȴ����û������----");
     }
     
     //������ǿ����ָ���е㣬�����쳣�������
     @AfterReturning("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterReturning() {
    	 logger.info("----�û�������----");
     }
     
     //�쳣��ǿ
     @AfterThrowing("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterException() {
    	 logger.error("�����쳣������");
     }
}
