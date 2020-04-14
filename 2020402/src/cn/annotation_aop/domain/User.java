package cn.annotation_aop.domain;

public class User {
      private Integer id;
      private String account;
      private String password;
      
      public User(String account, String password) {
    	  this.account = account;
    	  this.password = password;
      }
      
      public User(String account, String password, Integer id) {
    	  this.account = account;
    	  this.password = password;
    	  this.id = id;
      }
      
      public  User() {
    	  
      }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    public String toString(Integer id, String account, String password) {
    	return "User[id:"+id+", account:"+account+", password:"+password+"]";
    }
}  
