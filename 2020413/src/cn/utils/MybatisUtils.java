package cn.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory=null;
	//初始化sqlSessionFatory对象
	static {
		try {
			//使用myBatis提供的Resource类加载myBatis的配置文件
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			//构建sqlSessionFatory工厂
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	//提供sqlSession对象的方法
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
