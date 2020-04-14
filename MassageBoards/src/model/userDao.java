package model;

import java.util.HashMap;
import java.util.List;

public interface userDao {
    public boolean findUser(Notes person);
    public int insert(Notes person);
    public int delete(Notes person);
    public int update(Notes person);
    public int searchCount();
    List<HashMap> search(int pageSize,int ePageSize);
}
