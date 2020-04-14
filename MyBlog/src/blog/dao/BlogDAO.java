package blog.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import blog.util.SplitPage;
import blog.vo.Blog;

public interface BlogDAO {
     public void insert(Blog blog)throws Exception;
     public void delete(int id)throws Exception;
     public void update(Blog blog)throws Exception;
     public Blog queryById(int id)throws Exception;
     public ArrayList<Blog> queryAll()throws Exception;
     public ArrayList<Blog> queryByLike(String select,SplitPage sp)throws Exception;
     public int getRows(String select) throws Exception;
     public ArrayList<Blog> queryByLike(String select)throws Exception;
     public ArrayList<Blog> queryByType(String type) throws Exception; 
     }
