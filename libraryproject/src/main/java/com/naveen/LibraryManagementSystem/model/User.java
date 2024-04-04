package com.naveen.LibraryManagementSystem.model;

public class User {
	
	
	String id;
    String name;
    String phoneNo;
	String mailId;
	String address;
	String bookLimit;

	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}

	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	
	public void setMailId(String mailId)
	{
		this.mailId=mailId;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getphoneNo()
	{
		return phoneNo;
	}
	
	public String getMailId()
	{
		return mailId;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String getBookLimit()
	{
		return bookLimit;
	}
	
	public void increaseUserBookCount()
	{
		String.valueOf(Integer.parseInt(bookLimit+1));
	}
   
	public void decreaseBookCount()
	{
		String.valueOf(Integer.parseInt(bookLimit+1));
	}
	
	public void setUserBookCount(String count)
	{
		bookLimit=count;
	}
	
	public boolean checkLimit(String bookLimit)
	{
		int val=Integer.parseInt(bookLimit);
		return val>5;
	}
}
