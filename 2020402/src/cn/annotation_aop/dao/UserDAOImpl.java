package cn.annotation_aop.dao;

import cn.annotation_aop.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("userDao")//�������עΪһ��DAO���
public class UserDAOImpl implements UserDAO{
    @Autowired
	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertUser(User user) {
		//����SQL
		String sql="insert into t_user(id,account,password) value(id,?,?)";
		//�������������SQL�еĲ���
		Object[] objects = new Object[] {user.getAccount(),user.getPassword()		};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}

	@Override
	public int updateUser(User user) {
		//����SQL
		String sql="update t_user set account = ? ,password = ? where id = ?";
		//�������������SQL�еĲ���
		Object[] objects = new Object[] {user.getAccount(),user.getPassword(),user.getId()};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}
	@Override
	public int deleteUser(int id) {
		//����SQL
		String sql="delete from t_user where id = ?";
		int num = this.JdbcTemplate.update(sql,id);
		return num;
	}
	@Override
	public User selectUserById(int id) {
		//����SQL
		String sql="select * from t_user where id=?";
		//����һ���µ�RowMapper����
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		//��id�󶨵�SQL����У�ͨ��RowMapper����һ��Object���͵ĵ��м�¼
		return this.JdbcTemplate.queryForObject(sql, rowMapper,id);
	}
	@Override
	public List<User> selectAllUser() {
		//����SQL
		String sql="select * from t_user";
		//����һ���µ�RowMapper����
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		//ִ�о�̬SQL��ͨ��RowMapper���ؽ��
		return this.JdbcTemplate.query(sql, rowMapper);
	}
	

}
