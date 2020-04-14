package note.daoImpl;


import note.dao.NoteDAO;
import note.util.DataBaseConnection;
import note.util.SplitPage;
import note.vo.Note;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoteDAOImpl implements NoteDAO {

    @Override
    public void insert(Note note) throws Exception {

        String sql = "INSERT INTO note(id,title,author,content) VALUES(id,?,?,?)" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,note.getTitle()) ;
            pstmt.setString(2,note.getAuthor()) ;
            pstmt.setString(3,note.getContent()) ;
            pstmt.executeUpdate() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            dbc.close() ;
        }
    }

    @Override
    public void update(Note note) throws Exception {

        String sql = "UPDATE note SET title=?,author=?,content=? WHERE id=?" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setString(1,note.getTitle()) ;
            pstmt.setString(2,note.getAuthor()) ;
            pstmt.setString(3,note.getContent()) ;
            pstmt.setInt(4,note.getId()) ;
            pstmt.executeUpdate() ;
            pstmt.close() ;
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

    @Override
    public void delete(int id) throws Exception {

        String sql = "DELETE FROM note WHERE id=?" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,id) ;
            pstmt.executeUpdate() ;
            pstmt.close() ;
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

    @Override
    public Note queryById(int id) throws Exception {


        Note note = null ;
        String sql = "SELECT id,title,author,content FROM note WHERE id=?" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1,id) ;
            ResultSet rs = pstmt.executeQuery() ;
            if(rs.next())
            {
                note = new Note() ;
                note.setId(rs.getInt(1)) ;
                note.setTitle(rs.getString(2)) ;
                note.setAuthor(rs.getString(3)) ;
                note.setContent(rs.getString(4)) ;
            }
            rs.close() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace() ;
        }
        finally
        {
            dbc.close() ;
        }
        return note ;
    }

    @Override
    public List<Note> queryAll() throws Exception {

        List all = new ArrayList() ;
        String sql = "SELECT id,title,author,content FROM note" ;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery() ;
            while(rs.next())
            {
                Note note = new Note() ;
                note.setId(rs.getInt(1)) ;
                note.setTitle(rs.getString(2)) ;
                note.setAuthor(rs.getString(3)) ;
                note.setContent(rs.getString(4)) ;
                all.add(note) ;
            }
            rs.close() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace() ;
        }
        finally
        {
            dbc.close() ;
        }
        return all ;
    }

    @Override
    public List<Note> findAll(SplitPage sp) throws Exception {

        List<Note> list = new ArrayList<Note>();
        String sql = "select  * from note limit "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
        PreparedStatement pstmt=null;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery() ;
            while(rs.next()) {
                Note note=new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                list.add(note);

            }
            rs.close() ;
            pstmt.close() ;
        }catch(Exception e) {
            e.printStackTrace() ;
        } finally {
            dbc.close() ;
        }
        return list;
    }

    @Override
    public int getRows(HashMap tm) throws Exception {
        // TODO Auto-generated method stub
        List<Note> list=null;

        if(tm.isEmpty()) {
            list=queryAll();
        }else {
            list=queryByLike(tm);
        }
        int num=list.size();
        return num;
    }

    @Override
    public List<Note> queryByLike(HashMap cond) throws Exception {

        List<Note> all = new ArrayList<Note>() ;

        String str=null;
        if(cond.containsKey("title"))
            str="title LIKE "+"'"+cond.get("title")+"'";
        if(cond.containsKey("author"))
            str="author LIKE "+"'"+cond.get("author")+"'";
        if(cond.containsKey("content"))
            str="content LIKE "+"'"+cond.get("content")+"'";
        String sql = "SELECT id,title,author,content FROM note WHERE " +str;
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {   pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery() ;
            while(rs.next())
            {
                Note note = new Note() ;
                note.setId(rs.getInt(1)) ;
                note.setTitle(rs.getString(2)) ;
                note.setAuthor(rs.getString(3)) ;
                note.setContent(rs.getString(4)) ;
                all.add(note) ;
            }
            rs.close() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace() ;
        }
        finally
        {
            dbc.close() ;
        }
        return all ;
    }

    @Override
    public List<Note> queryByLike(HashMap cond, SplitPage sp) throws Exception {

        List<Note> all = new ArrayList<Note>() ;
        String str=null;
        if(cond.containsKey("title"))
            str="title LIKE "+"'"+cond.get("title")+"'";
        if(cond.containsKey("author"))
            str="author LIKE "+"'"+cond.get("author")+"'";
        if(cond.containsKey("content"))
            str="content LIKE "+"'"+cond.get("content")+"'";
        String sql = "SELECT  * FROM note WHERE "+str+" LIMIT "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
        PreparedStatement pstmt = null ;
        DataBaseConnection dbc = null ;
        dbc = new DataBaseConnection() ;
        try
        {
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery(sql) ;
            while(rs.next())
            {
                Note note = new Note() ;
                note.setId(rs.getInt(1)) ;
                note.setTitle(rs.getString(2)) ;
                note.setAuthor(rs.getString(3)) ;
                note.setContent(rs.getString(4)) ;
                all.add(note) ;
            }
            rs.close() ;
            pstmt.close() ;
        }
        catch (Exception e)
        {
            e.printStackTrace() ;
        }
        finally
        {
            dbc.close() ;
        }
        return all ;

    }

}