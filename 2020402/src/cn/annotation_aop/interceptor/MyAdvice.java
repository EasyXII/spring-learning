package cn.annotation_aop.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.annotation_aop.dao.UserDAOImpl;
import cn.annotation_aop.domain.User;
/**
 * �Զ�����ǿ��
 */
@Aspect
@Component
public class MyAdvice {
     private final Logger logger = LogManager.getLogger(UserDAOImpl.class);
     
     //�е㣬��DAOImpl����ӷ���
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.insertUser(..))")
     public void pc1() {
    	 
     }
     //�е㣬��DAOImpl�ĸ��·���
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.updateUser(..))")
     public void pc2() {
    	 
     }
     //�е㣬��DAOImpl��ɾ������
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.deleteUser(..))")
     public void pc3() {
    	 
     }
     //�е㣬��DAOImpl�Ĳ�ѯ����1
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.selectUserById(..))")
     public void pc4() {
    	 
     }
   //�е㣬��DAOImpl�Ĳ�ѯ����2
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.selectAllUser(..))")
     public void pc5() {
    	 
     }
     
     //ǰ����ǿ����ָ���е�
     @Before("MyAdvice.pc1()")
     public void before1() {
    	 logger.info("----�ȴ����û������----");
     }
     @Before("MyAdvice.pc2()")
     public void before2() {
    	 logger.info("----�����û���----");
     }
     @Before("MyAdvice.pc3()")
     public void before3() {
    	 logger.info("----ɾ���û���----");
     }
     @Before("MyAdvice.pc4()")
     public void before4() {
    	 logger.info("----�����������û�----");
     }
     @Before("MyAdvice.pc5()")
     public void before5() {
    	 logger.info("----�����г������û�----");
     }
     
     //������ǿ����ָ���е㣬�����쳣�������
     @AfterReturning("MyAdvice.pc1()")
     public void afterReturning1() {
    	 logger.info("----�û�������----");
     }
     @AfterReturning("MyAdvice.pc2()")
     public void AfterReturning2() {
    	 logger.info("----�Ѹ���----");
     }
     @AfterReturning("MyAdvice.pc3()")
     public void AfterReturning3() {
    	 logger.info("----��ɾ��----");
     }
     @AfterReturning("MyAdvice.pc4()")
     public void AfterReturning4() {
    	 logger.info("----�������----");
     }
     @AfterReturning("MyAdvice.pc5()")
     public void AfterReturning5() {
    	 logger.info("----����Ϊ�����û���Ϣ----");
     }
     //�쳣��ǿ
     @AfterThrowing("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterException() {
    	 logger.error("�����쳣������");
     }
}
