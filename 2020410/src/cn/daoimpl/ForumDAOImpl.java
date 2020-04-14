package cn.daoimpl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import cn.utils.MybatisUtil;


public class ForumDAOImpl implements ForumDAO{
	
	/*
	 * session成员变量
	 */
	SqlSession session;
	@Override
	public int insertForum(Forum forum) throws IOException{
		session = MybatisUtil.getSession(); //获取session
		int result = session.insert("insertForum",forum); //添加insert
		session.commit(); //添加事务
		session.close(); //关闭session
		return result;
	}

	@Override
	public List<Forum> getAllForums() {
		//定义SQL
		String sql="select * from t_forum";
		//创建一个新的RowMapper对象
		RowMapper<Forum> rowMapper = new BeanPropertyRowMapper<Forum>(Forum.class);
		//执行静态SQL，通过RowMapper返回结果
		return this.JdbcTemplate.query(sql, rowMapper);
	}

}
