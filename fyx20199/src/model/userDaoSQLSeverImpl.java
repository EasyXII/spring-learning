package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

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
		String sql = "insert into users (userid, username, password) values(?,?,?)";
		Object[] params = {user.getUserID(),user.getUsername(),user.getPassword()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	@Override
	public int delete(Users user) {
		// TODO Auto-generated method stub
		String sql = "delete from user where userid = ?";
		Object[] params = {user.getUserID()};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		return i;
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchCount() {
		// TODO Auto-generated method stub
		String sql = "Select * from users";
		Object[] params = {users.getUserID(),users.getUsername(),users.getPassword(),};
		List<HashMap> listMatser = new ArrayList<HashMap>();
		int i=this.executeUpdate(sql,params);
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement)new JDBCUtil().getConnection().prepareStatement(sql);
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		int t=0;
		try {
			while(rs.next()) {
				t++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
