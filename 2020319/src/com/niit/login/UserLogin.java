package com.niit.login;



public class UserLogin {

    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    public boolean userLogin(User user) {
    	   boolean a = false;
    	if("admin".equals(user.getAccount())&&"111".equals(user.getPassword())) {
    		a = true;
    	}
    
		return a;
    }
    
}
