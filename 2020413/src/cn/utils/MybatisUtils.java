package cn.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory=null;
	//��ʼ��sqlSessionFatory����
	static {
		try {
			//ʹ��myBatis�ṩ��Resource�����myBatis�������ļ�
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			//����sqlSessionFatory����
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	//�ṩsqlSession����ķ���
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
