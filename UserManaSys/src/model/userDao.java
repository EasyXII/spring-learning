package model;

import java.util.HashMap;
import java.util.List;

public interface userDao {
    public boolean findUser(Users user);
    public int insert(Users user);
    public int delete(int id);
   
    public int searchCount();
    public String searchUser(Users user);
    List<HashMap> search(int pageSize,int ePageSize);
}
