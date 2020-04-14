package cn.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 工具�?
 *
 */
public class MybatisUtil {
    private static String config="mybatis-config.xml";
    static Reader reader;
    static{
        try {
            reader= Resources.getResourceAsReader(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
    //提供�?个可以获取到session的方�?
    public static SqlSession getSession() throws IOException{
        
           // 1.1 openSession到底做了�?�?
           SqlSession session = factory.openSession();
           //System.out.println("3333");
            return session;
    }
}