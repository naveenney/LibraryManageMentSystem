package com.naveen.LibraryManagementSystem.model;

public class AdminCredentials {
	
	private String userName;
	private String passWord;
	
	public AdminCredentials()
	{
		userName="Zsgs";
		passWord="admin";
	}
	
     public void setAdminUserName(String name)
     {
    	userName=name; 
     }
     
     public void setAdminPassword(String password)
     {
    	 passWord=password;
     }
     
     public String getAdminUserName()
     {
    	return userName; 
     }
     public String getAdminPassWord()
     {
    	 return passWord;
     }
}
