package com.itheima.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.itheima.po.Customer;
/**
 * 入门程序测试类
 */
class MybatisTest {
    /**
              * 根据客户编号查询客户信息
     */
	@Test
	public void findCustomerByIdTest() throws Exception{
		//1.读取配置文件
		 String resource = "mybatis-config.xml";
		 InputStream inputStream = Resources.getResourceAsStream(resource);
		//2.根据配置文件构建SqlSessionFactory
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3.通过SQLSessionFactory创建SqlSession
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.SqlSession执行映射文件中定义的SQL,并返回映射结果
		 Customer customer = sqlSession.selectOne("com.itheima.mapper.CustomerMapper.findCustomerById",1);
		 //打印输出结果
		 System.out.println(customer.toString());
		//5.关闭SqlSession
		 sqlSession.close();
	}
}
