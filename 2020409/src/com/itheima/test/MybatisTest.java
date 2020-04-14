package com.itheima.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.itheima.po.Customer;
/**
 * ���ų��������
 */
class MybatisTest {
    /**
              * ���ݿͻ���Ų�ѯ�ͻ���Ϣ
     */
	@Test
	public void findCustomerByIdTest() throws Exception{
		//1.��ȡ�����ļ�
		 String resource = "mybatis-config.xml";
		 InputStream inputStream = Resources.getResourceAsStream(resource);
		//2.���������ļ�����SqlSessionFactory
		 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3.ͨ��SQLSessionFactory����SqlSession
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.SqlSessionִ��ӳ���ļ��ж����SQL,������ӳ����
		 Customer customer = sqlSession.selectOne("com.itheima.mapper.CustomerMapper.findCustomerById",1);
		 //��ӡ������
		 System.out.println(customer.toString());
		//5.�ر�SqlSession
		 sqlSession.close();
	}
}
