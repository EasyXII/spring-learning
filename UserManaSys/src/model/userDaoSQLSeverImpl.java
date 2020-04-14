package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Users;
import model.JDBCUtil;

public class userDaoSQLSeverImpl extends JDBCUtil implements userDao{

	@Override
	public boolean findUser(Users user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "select * from users where username=? and password=?";
		Object[] params = {user.getUsername(),user.getPassword()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		listMatser = this.executeQuery(sql, params);
		if(listMatser.size()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int insert(Users user) {
		// TODO Auto-generated method stub
		String sql = "insert into users (userID, username, password) values(?,?,?)";
		Object[] params = {user.getUserID(),user.getUsername(),user.getPassword()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userID = ?";
		Object[] params = {id};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	public int update(Users user) {
		// TODO Auto-generated method stub
		 String sql="update users set username=?,password=?,email=?,grade=? where userId=?";
		 Object[] params= {user.getUsername(),user.getPassword(),user.getEmail(),user.getGrade(),user.getUserID()};
		 return this.executeUpdate(sql, params);
	}

	@Override
	//返回页面的数目，也就是在屏幕上共显示几页
	public int searchCount() {
		// TODO Auto-generated method stub
		int pageCount;
		int pageSize = 3;
		int rowCount;
		List<HashMap> lists = new ArrayList<HashMap>();
		String sql="select * from users";
		lists = this.executeQuery(sql, null);
		rowCount = lists.size();
		if(rowCount%pageSize==0) {
			pageCount = rowCount/pageSize;
		}else {
			pageCount = rowCount/pageSize+1;
		}
		return pageCount;//pageCount就是要显示的页面数
	}

	/**
	 * pageSize表示从第几条记录开始显示
	 * ePageSize表示共显示几条记录
	 */
	public List<HashMap> search(int pageSize, int ePageSize) {
		// TODO Auto-generated method stub
		List<HashMap> lists = new ArrayList<HashMap>();
		String sql="Select * from users limit ?,?";
		Object[] params = {pageSize,ePageSize};
		lists=this.executeQuery(sql, params);
		return lists;
	}
	public String searchUser(Users user) {
		String sql = "select * from users where username=?";
		Object[] params = { user.getUsername()};
		List<HashMap> listUser = new ArrayList<HashMap>();
		listUser = this.executeQuery(sql, params);
		return listUser.toString();
	}




	

}
