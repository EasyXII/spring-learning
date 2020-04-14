package note.daoImpl;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import note.dao.PersonDAO;
import note.util.DataBaseConnection;
import note.vo.Person;

public class PersonDAOImpl implements PersonDAO{

@Override
public boolean login(Person person) throws Exception {
	// TODO Auto-generated method stub
	boolean flag=false;
	String sql = "select active,image,id from person where name=? and password=? and flag=?";
	DataBaseConnection dbc=null;
	PreparedStatement pstmt=null;
	dbc = new DataBaseConnection();
	try {
	pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql); 
	pstmt.setString(1,person.getName());
	pstmt.setString(2, person.getPassword());
	pstmt.setString(3, person.getFlag());
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		flag=true;
		person.setActive(rs.getString(1));
		person.setImage(rs.getString(2));
		person.setId(rs.getString(3));
	}
	}catch(Exception e) {
        e.printStackTrace();
	}finally {
		dbc.close();
	}
	return flag;
}

@Override
public boolean register(Person person) throws Exception {
	// TODO Auto-generated method stub
	boolean b = false;
	String sql = "Insert into person (id,name,password,email,flag,active,image) values (id,?,?,?,?,?,?)";
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	try {
		pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,person.getName());
		pstmt.setString(2,person.getPassword());
		pstmt.setString(3,person.getEmail());
		pstmt.setString(4,person.getFlag());
		pstmt.setString(5,person.getActive());
		pstmt.setString(6,person.getImage());
		pstmt.executeUpdate();
		b = true;
		pstmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbc.close();
	}
	return b;
}

@Override
public boolean checkUser(Person person) throws Exception {
	// TODO Auto-generated method stub
	boolean b = false;
	String sql = "select name from person where name = ?";
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	try {
	    pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1, person.getName());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			b = true;
		}
		pstmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbc.close();
	}
	return b;
}

@Override
public String QueryId(Person person) throws Exception {
	// TODO Auto-generated method stub
	//boolean b=false;
	String b="";
	String sql = "select id from person where name = ?";
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	try {
		  pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		  pstmt.setString(1, person.getName());
		  ResultSet rs = pstmt.executeQuery();
		  if(rs.next()) {
			 // b=true;
			  b = rs.getString(1);
		  }
		  rs.close();
		  pstmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbc.close();
	}
	return b ;
}

@Override
public boolean checkUserById(String id) throws Exception {
	// TODO Auto-generated method stub
	boolean b = false;
	String sql = "select name from person where id = ?";
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	try {
		pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
		     b = true;
		}
		rs.close();
		pstmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbc.close();
	}
	return b;
}

@Override
public Person checkPersonById(String id) throws Exception {
	// TODO Auto-generated method stub
	String sql = "select * from person where id = ?";
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	Person person = new Person();
	try {
		pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			person.setId(rs.getString(1)) ;
		    person.setName(rs.getString(2));
		    person.setPassword(rs.getString(3));
		    person.setEmail(rs.getString(4));
		    person.setFlag(rs.getString(5));
		    person.setActive(rs.getString(6));
		    person.setImage(rs.getString(7));
		}
		rs.close();
		pstmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		dbc.close();
	}
	return person;
}

@Override
public void update(String id) throws Exception {
	// TODO Auto-generated method stub
	String sql = "Update person set active = ? where id = ?";
	System.out.println("id"+id);
	PreparedStatement pstmt = null;
	DataBaseConnection dbc = null;
	dbc = new DataBaseConnection();
	try {
		pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1, "1");
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	}catch(Exception e) {		
		e.printStackTrace();
	}finally {
		dbc.close();
	}
}
public void update(Person person) throws Exception {
	// TODO Auto-generated method stub
	String sql = "UPDATE person SET image=? WHERE id=?" ;
	PreparedStatement pstmt = null ;
	DataBaseConnection dbc = null ;
	dbc = new DataBaseConnection() ;
	try
	{
		pstmt = (PreparedStatement) dbc.getConnection().prepareStatement(sql) ;
		pstmt.setString(1,person.getImage()) ;			
		pstmt.setString(2,person.getId()) ;			
		pstmt.executeUpdate() ;
		pstmt.close() ;
		//System.out.println("ima"+person.getImage()+"id"+person.getId());
	}
	catch (Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		dbc.close() ;
	}
}

}