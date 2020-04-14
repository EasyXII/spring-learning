package cn.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cn.dao.ForumDAO;
import cn.domain.Forum;

@Service
public class ForumDAOImpl implements ForumDAO{
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertForum(Forum forum) {
		//����SQL
		String sql = "insert into t_forum (forum_id,forum_name,description,image) value(forum_id,?,?,?)";
		//�������������SQL�еĲ���
		Object[] objects = new Object[] {forum.getForum_name(),forum.getDescription(),forum.getImage()};
		int num = this.JdbcTemplate.update(sql, objects);
		return num;
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
