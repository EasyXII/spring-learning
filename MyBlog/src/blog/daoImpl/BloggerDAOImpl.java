package blog.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import blog.dao.BloggerDAO;
import blog.util.DataBaseConnection;
import blog.vo.Blogger;
import blog.vo.Image;

public class BloggerDAOImpl implements BloggerDAO{

	public boolean login(Blogger blogger) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select name,email,signature,image from blogger where id=? and password=?";
		DataBaseConnection dbc = new DataBaseConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, blogger.getId());
			pstmt.setString(2, blogger.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true;
				blogger.setName(rs.getString(1));
				blogger.setEmail(rs.getString(2));
				blogger.setSignature(rs.getString(3));
				blogger.setImage(rs.getString(4));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return flag;
	}

	@Override
	public ArrayList album() throws Exception {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
 		String sql = "select * from image";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Image image=new Image();
				image.setId(rs.getInt(1));
				image.setImage(rs.getString(2));
				image.setName(rs.getString(3));
				list.add(image);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		System.out.println(list);
		return  list;
	}

	@Override
	public void insertimg(Image img) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Insert into Image(id, image, name) values(id, ?, ?)";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, img.getImage());
			pstmt.setString(2, img.getName());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	@Override
	//���¸�����Ϣ
	public void update(Blogger blogger) throws Exception {
		String sql = " Update blogger set name=?, email=?, signature=?, image=? where id = 1";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, blogger.getName());
			pstmt.setString(2, blogger.getEmail());
			pstmt.setString(3, blogger.getSignature());
			pstmt.setString(4, blogger.getImage());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
	}

	@Override
	public void updatepassword(String password) throws Exception {
		String sql = "Update blogger set password = ? where id = 1";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		
	}
	@Override
	public ArrayList<Blogger> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Blogger> list = new ArrayList<Blogger>();
        String sql = "select * from blogger";
        
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery() ;
            while(rs.next()) {
            	Blogger blgr=new Blogger();
                blgr.setId(rs.getInt(1));
                blgr.setName(rs.getString(2));
                blgr.setEmail(rs.getString(4));
                blgr.setSignature(rs.getString(5));
                blgr.setImage(rs.getString(6));
                list.add(blgr);

            }
            rs.close() ;
            pstmt.close() ;
        }catch(Exception e) {
            e.printStackTrace() ;
        } finally {
            dbc.close() ;
        }
        return (ArrayList<Blogger>) list;
	}
}
