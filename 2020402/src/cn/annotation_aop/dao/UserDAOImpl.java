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
@Repository("userDao")//将本类标注为一个DAO组件
public class UserDAOImpl implements UserDAO{
    @Autowired
	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertUser(User user) {
		//定义SQL
		String sql="insert into t_user(id,account,password) value(id,?,?)";
		//定义数组来存放SQL中的参数
		Object[] objects = new Object[] {user.getAccount(),user.getPassword()		};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}

	@Override
	public int updateUser(User user) {
		//定义SQL
		String sql="update t_user set account = ? ,password = ? where id = ?";
		//定义数组来存放SQL中的参数
		Object[] objects = new Object[] {user.getAccount(),user.getPassword(),user.getId()};
		int num = this.JdbcTemplate.update(sql,objects);
		return num;
	}
	@Override
	public int deleteUser(int id) {
		//定义SQL
		String sql="delete from t_user where id = ?";
		int num = this.JdbcTemplate.update(sql,id);
		return num;
	}
	@Override
	public User selectUserById(int id) {
		//定义SQL
		String sql="select * from t_user where id=?";
		//创建一个新的RowMapper对象
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		//将id绑定到SQL语句中，通过RowMapper返回一个Object类型的单行记录
		return this.JdbcTemplate.queryForObject(sql, rowMapper,id);
	}
	@Override
	public List<User> selectAllUser() {
		//定义SQL
		String sql="select * from t_user";
		//创建一个新的RowMapper对象
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		//执行静态SQL，通过RowMapper返回结果
		return this.JdbcTemplate.query(sql, rowMapper);
	}
	

}
