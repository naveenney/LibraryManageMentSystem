package com.naveen.LibraryManagementSystem.model;

public class UserCredentials {

	private String userName;
	private String passWord;

	public UserCredentials() {
		}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassWord() {
		return passWord;
	}
	
	public boolean userContains(String username,String password)
	{
		return userName.equals(username)&&passWord.contains(password);
		
	}

}
