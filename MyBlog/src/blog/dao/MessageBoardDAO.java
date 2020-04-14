package blog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import blog.util.SplitPage;
import blog.vo.Messageboard;

public interface MessageBoardDAO {
       public void insert(Messageboard mb)throws Exception;
       public void delete(int id)throws Exception;
       public void reply(Messageboard mb ,int id)throws Exception;
       public ArrayList<Messageboard> queryAll() throws Exception;
       public List<Messageboard> findAll(SplitPage sp)throws Exception;
       public int getRow()throws Exception;
       public List<Messageboard> queryBylike(SplitPage sp)throws Exception;
}
