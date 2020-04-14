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
 * 自定义增强类
 */
@Aspect
@Component
public class MyAdvice {
     private final Logger logger = LogManager.getLogger(UserDAOImpl.class);
     
     //切点，对DAOImpl的添加方法
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.insertUser(..))")
     public void pc1() {
    	 
     }
     //切点，对DAOImpl的更新方法
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.updateUser(..))")
     public void pc2() {
    	 
     }
     //切点，对DAOImpl的删除方法
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.deleteUser(..))")
     public void pc3() {
    	 
     }
     //切点，对DAOImpl的查询方法1
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.selectUserById(..))")
     public void pc4() {
    	 
     }
   //切点，对DAOImpl的查询方法2
     @Pointcut("execution(* cn.annotation_aop.dao.UserDAOImpl.selectAllUser(..))")
     public void pc5() {
    	 
     }
     
     //前置增强，并指定切点
     @Before("MyAdvice.pc1()")
     public void before1() {
    	 logger.info("----等待新用户的添加----");
     }
     @Before("MyAdvice.pc2()")
     public void before2() {
    	 logger.info("----更新用户中----");
     }
     @Before("MyAdvice.pc3()")
     public void before3() {
    	 logger.info("----删除用户中----");
     }
     @Before("MyAdvice.pc4()")
     public void before4() {
    	 logger.info("----正在搜索该用户----");
     }
     @Before("MyAdvice.pc5()")
     public void before5() {
    	 logger.info("----正在列出所有用户----");
     }
     
     //后置增强，并指定切点，出现异常不会调用
     @AfterReturning("MyAdvice.pc1()")
     public void afterReturning1() {
    	 logger.info("----用户添加完成----");
     }
     @AfterReturning("MyAdvice.pc2()")
     public void AfterReturning2() {
    	 logger.info("----已更新----");
     }
     @AfterReturning("MyAdvice.pc3()")
     public void AfterReturning3() {
    	 logger.info("----已删除----");
     }
     @AfterReturning("MyAdvice.pc4()")
     public void AfterReturning4() {
    	 logger.info("----搜索完成----");
     }
     @AfterReturning("MyAdvice.pc5()")
     public void AfterReturning5() {
    	 logger.info("----以下为所有用户信息----");
     }
     //异常增强
     @AfterThrowing("execution(* cn.annotation_aop.dao.UserDAOImpl.*(..))")
     public void afterException() {
    	 logger.error("出现异常！！！");
     }
}
