package cn.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cn.dao.PostDAO;
import cn.domain.Post;
@Service
public class PostDAOImpl implements PostDAO{
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertPost(Post post) {
		//����SQL
		String sql="insert into t_post(post_id,forum_id,title,content,thumbnail,post_time,account) value(post_id,?,?,?,?,?,?)";
		//�������������SQL�еĲ���
	    Object[] objects = new Object[] {post.getForum_id(),post.getTitle(),post.getContent(),post.getThumbnail(),post.getPost_time(),post.getAccount()};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}

	@Override
	public int deletePost(int post_id) {
		//����SQL
		String sql="delete from t_post where post_id = ?";
		int num = this.JdbcTemplate.update(sql,post_id);
		return num;
	}

	@Override
	public Post getPostById(int post_id) {
		//����SQL
		String sql="select * from t_post where post_id=?";
		//����һ���µ�RowMapper����
		RowMapper<Post> rowMapper = new BeanPropertyRowMapper<Post>(Post.class);
		//��id�󶨵�SQL����У�ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		return this.JdbcTemplate.queryForObject(sql, rowMapper,post_id);
	}

	@Override
	public int updatePost(Post post) {
		String sql="update t_post set forum_id=? ,title=? ,content=? ,thumbnail=? ,post_time=? ,account=? where post_id=?";
		Object[] objects = new Object[] {post.getForum_id(),post.getTitle(),post.getContent(),post.getThumbnail(),post.getPost_time(),post.getAccount(),post.getPost_id()};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}

	@Override
	public List<Post> getPostsByForumId(int forum_id) {
		String sql="select * from t_post where forum_id = ?";
		RowMapper<Post> rowMapper = new BeanPropertyRowMapper<Post>(Post.class);
		return this.JdbcTemplate.query(sql, rowMapper, forum_id);
	}

	@Override
	public int getCountByForumId(int forum_id) {
		String sql="select count(*) from t_post where forum_id = ?";
		RowMapper<Integer> rowMapper = new BeanPropertyRowMapper<Integer>(Integer.class);
		return this.JdbcTemplate.queryForObject(sql, rowMapper, forum_id);
	}

}