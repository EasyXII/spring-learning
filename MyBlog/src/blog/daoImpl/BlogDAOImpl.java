package blog.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import blog.dao.BlogDAO;
import blog.util.DataBaseConnection;
import blog.util.SplitPage;
import blog.vo.Blog;

public class BlogDAOImpl implements BlogDAO{

	public void insert(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String sql = "Insert into blog(id,author,content,title,type,time) Values(id,?,?,?,?,?)" ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, blog.getAuthor());
			pstmt.setString(2, blog.getContent());
			pstmt.setString(3, blog.getTitle());
			pstmt.setString(4, blog.getType());
			pstmt.setTimestamp(5, time);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Delete From blog Where id = ?" ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	@Override
	public void update(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		Timestamp time = new Timestamp(System.currentTimeMillis());
		String sql = "Update blog Set author=?, content=?, title=?, type=?, time=? Where id=?" ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, blog.getAuthor());
			pstmt.setString(2, blog.getContent());
			pstmt.setString(3, blog.getTitle());
			pstmt.setString(4, blog.getType());
			pstmt.setTimestamp(5, time);
			pstmt.setInt(6, blog.getId());
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			dbc.close();
		}
	}


	@Override
	public Blog queryById(int id) throws Exception {
		// TODO Auto-generated method stub
		Blog blog = null;
		String sql = "select * from blog where id = ?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				blog = new Blog();
				blog.setId(rs.getInt(1));
				blog.setAuthor(rs.getString(2));
				blog.setContent(rs.getString(3));
				blog.setTitle(rs.getString(4));
				blog.setType(rs.getString(5));
				blog.setTime(rs.getDate(6));
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return blog;
	}


	@Override
	public ArrayList<Blog> queryAll() throws Exception {
		// TODO Auto-generated method stub
		List all = new ArrayList();
		String sql = "select * from blog" ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Blog blog = new Blog();
				blog.setId(rs.getInt(1));
				blog.setAuthor(rs.getString(2));
				blog.setContent(rs.getString(3));
				blog.setTitle(rs.getString(4));
				blog.setType(rs.getString(5));
				blog.setTime(rs.getTimestamp(6));
				all.add(blog);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return (ArrayList<Blog>) all;
	}

     	public ArrayList<Blog> queryByLike(String select,SplitPage sp) throws Exception {
		// TODO Auto-generated method stub
		List<Blog> all = new ArrayList<Blog>();
		String sql = "select author, content, title, type, time from blog where title like '%"+select+"%' LIMIT "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Blog blog = new Blog();
				blog.setAuthor(rs.getString(1));
				blog.setContent(rs.getString(2));
				blog.setTitle(rs.getString(3));
				blog.setType(rs.getString(4));
				blog.setTime(rs.getTimestamp(5));
				all.add(blog);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return (ArrayList<Blog>) all;
	}

	@Override
	public int getRows(String select) throws Exception {
		// TODO Auto-generated method stub
		List<Blog> list=null;
		if(select != "select") {
			list=queryByLike(select);
        }else {
        	list=queryAll();
        }
		int num = list.size();
		return num;
	}

	@Override
	public ArrayList<Blog> queryByLike(String select) throws Exception {
		List<Blog> all = new ArrayList<Blog>();
		String sql = "select author, content, title, type, time from blog where title like '%"+select+"%'";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Blog blog = new Blog();
				blog.setAuthor(rs.getString(1));
				blog.setContent(rs.getString(2));
				blog.setTitle(rs.getString(3));
				blog.setType(rs.getString(4));
				blog.setTime(rs.getTimestamp(5));
				all.add(blog);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return (ArrayList<Blog>) all;
	}

	@Override
	public ArrayList<Blog> queryByType(String type) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Blog> all = new ArrayList<Blog>();
 		String sql = "select author, content, title, type, time from blog where type = '"+type+"'";
 		PreparedStatement pstmt = null;
 		DataBaseConnection dbc = new DataBaseConnection();
 		try {
 			 pstmt = dbc.getConnection().prepareStatement(sql);
 			 ResultSet rs = pstmt.executeQuery();
 			 while(rs.next()) {
 				 Blog blog = new Blog();
 				 blog.setAuthor(rs.getString(1));
				 blog.setContent(rs.getString(2));
				 blog.setTitle(rs.getString(3));
				 blog.setType(rs.getString(4));
				 blog.setTime(rs.getTimestamp(5));
				 all.add(blog);
 			 }
 			 rs.close();
 			 pstmt.close();
 		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return all;
	}
     
}
