package com.niit.login;


public class User {
     public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	private String account;
     private String password;
     
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
	public String toString() {
    	return "用户"+account+"登录成功！！";
    }
}
