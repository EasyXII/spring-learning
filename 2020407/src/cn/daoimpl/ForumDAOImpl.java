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
		//定义SQL
		String sql = "insert into t_forum (forum_id,forum_name,description,image) value(forum_id,?,?,?)";
		//定义数组来存放SQL中的参数
		Object[] objects = new Object[] {forum.getForum_name(),forum.getDescription(),forum.getImage()};
		int num = this.JdbcTemplate.update(sql, objects);
		return num;
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
