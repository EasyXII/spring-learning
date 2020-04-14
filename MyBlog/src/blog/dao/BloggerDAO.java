package blog.dao;

import java.util.ArrayList;
import java.util.List;

import blog.vo.Blogger;
import blog.vo.Image;

public interface BloggerDAO {
       public boolean login(Blogger blogger) throws Exception;
       public ArrayList album() throws Exception;
       public void insertimg(Image img)throws Exception;
       public void update(Blogger blogger) throws Exception;
       public void updatepassword(String password) throws Exception;
       public ArrayList<Blogger> findAll() throws Exception;
}
