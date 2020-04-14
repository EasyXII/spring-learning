package model;

public interface userDao {
    public boolean findUser(Users user);
    public int insert(Users user);
    public int delete(Users user);
    public int update(Users user);
    public int searchCount();

}
