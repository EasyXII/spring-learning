package blog.daoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import blog.dao.MessageBoardDAO;
import blog.util.DataBaseConnection;
import blog.util.SplitPage;
import blog.vo.Blog;
import blog.vo.Messageboard;

public class MessageBoardDAOImpl implements MessageBoardDAO{



	@Override
	//É¾³ýÁôÑÔ
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from messageboard where id ="+id ;
		System.out.println(sql);
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			int i=pstmt.executeUpdate();
			System.out.println(i+"Ìõ¼ÇÂ¼±»É¾³ý");
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	@Override
	public void reply(Messageboard mb, int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Update messageboard set reply = ? where id = ?" ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, mb.getReply());
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		
	}

	@Override
	public ArrayList<Messageboard> queryAll() throws Exception {
		// TODO Auto-generated method stub
		List<Messageboard> all = new ArrayList<Messageboard>();
		String sql = "select id, name, content, reply, time from messageboard ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Messageboard mb = new Messageboard();
				mb.setId(rs.getInt(1));
				mb.setName(rs.getString(2));
				mb.setContent(rs.getString(3));
				mb.setReply(rs.getString(4));
				mb.setTime(rs.getTimestamp(5));
				all.add(mb);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return (ArrayList<Messageboard>) all;
	}

	@Override
	public List<Messageboard> findAll(SplitPage sp) throws Exception {
		// TODO Auto-generated method stub
		List<Messageboard> list = new ArrayList<Messageboard>();
		String sql = "select name, content, reply, time from messageboard limit "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows() ;
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Messageboard mb = new Messageboard();
				mb.setName(rs.getString(1));
				mb.setContent(rs.getString(2));
				mb.setReply(rs.getString(3));
				mb.setTime(rs.getTimestamp(4));
				list.add(mb);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return list;
	}

	@Override
	//Ìí¼ÓÁôÑÔ
	public void insert(Messageboard mb) {
			
		    Timestamp time = new Timestamp(System.currentTimeMillis());
			String sql = "insert into messageboard(id, name, content, time) values (id, ?, ?, ?) " ; 
			PreparedStatement pstmt = null;
			DataBaseConnection dbc = new DataBaseConnection();
			try {
				pstmt = dbc.getConnection().prepareStatement(sql);
				pstmt.setString(1, mb.getName());
				pstmt.setString(2, mb.getContent());
				pstmt.setTimestamp(3, time);
				pstmt.executeUpdate();
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				dbc.close();
			}
	}

	@Override
	public int getRow() throws Exception {
		// TODO Auto-generated method stub
		List<Messageboard> list=null;
		list = queryAll();
		int num = list.size();
		return num;
	}

	@Override
	public List<Messageboard> queryBylike(SplitPage sp) throws Exception {
		// TODO Auto-generated method stub
		List<Messageboard> all = new ArrayList();
		String sql = "select * from messageboard LIMIT "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows()*sp.getCurrentPage();
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Messageboard mb = new Messageboard();
				mb.setName(rs.getString(2));
				mb.setContent(rs.getString(3));
				mb.setReply(rs.getString(4));
				mb.setTime(rs.getTimestamp(5));
				all.add(mb);
			}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
