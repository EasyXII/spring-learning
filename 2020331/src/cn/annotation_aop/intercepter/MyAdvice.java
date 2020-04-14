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
 * 自定义增强类
 */
@Aspect
@Component
public class MyAdvice {
     private final Logger logger = LogManager.getLogger(UserDAOImpl.class);
     
     //切点，对DAOImpl的所有方法
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void pc() {
    	 
     }
     
     //前置增强，并指定切点
     @Before("MyAdvice.pc()")
     public void before() {
    	 logger.info("----等待新用户的添加----");
     }
     
     //后置增强，并指定切点，出现异常不会调用
     @AfterReturning("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterReturning() {
    	 logger.info("----用户添加完成----");
     }
     
     //异常增强
     @AfterThrowing("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterException() {
    	 logger.error("出现异常！！！");
     }
}
