package cn.daoimpl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import cn.utils.MybatisUtil;


public class ForumDAOImpl implements ForumDAO{
	
	/*
	 * session��Ա����
	 */
	SqlSession session;
	@Override
	public int insertForum(Forum forum) throws IOException{
		session = MybatisUtil.getSession(); //��ȡsession
		int result = session.insert("insertForum",forum); //���insert
		session.commit(); //�������
		session.close(); //�ر�session
		return result;
	}

	@Override
	public List<Forum> getAllForums() {
		//����SQL
		String sql="select * from t_forum";
		//����һ���µ�RowMapper����
		RowMapper<Forum> rowMapper = new BeanPropertyRowMapper<Forum>(Forum.class);
		//ִ�о�̬SQL��ͨ��RowMapper���ؽ��
		return this.JdbcTemplate.query(sql, rowMapper);
	}

}
