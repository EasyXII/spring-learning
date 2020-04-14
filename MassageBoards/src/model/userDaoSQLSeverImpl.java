package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class userDaoSQLSeverImpl extends JDBCUtil implements userDao{

	@Override
	public boolean findUser(Notes person) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "select * from person where name=? and password=?";
		Object[] params = {person.getName(),person.getPassword()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		listMatser = this.executeQuery(sql, params);
		if(listMatser.size()>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int insert(Notes person) {
		// TODO Auto-generated method stub
		String sql = "insert into person (id, name, password) values(?,?,?)";
		Object[] params = {person.getId(),person.getName(),person.getPassword()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	@Override
	public int delete(Notes person) {
		// TODO Auto-generated method stub
		String sql = "delete from person where id = ?";
		Object[] params = {person.getId()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	@Override
	public int update(Notes person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	//返回页面的数目，也就是在屏幕上共显示几页
	public int searchCount() {
		// TODO Auto-generated method stub
		int pageCount;
		int pageSize = 3;
		int rowCount;
		List<HashMap> lists = new ArrayList<HashMap>();
		String sql="select * from person";
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
		String sql="Select * from person limit ?,?";
		Object[] params = {pageSize,ePageSize};
		lists=this.executeQuery(sql, params);
		return lists;
	}
	

}
