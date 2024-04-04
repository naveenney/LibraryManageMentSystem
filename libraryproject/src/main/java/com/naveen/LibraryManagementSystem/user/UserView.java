package com.naveen.LibraryManagementSystem.user;
import java.util.*;
public class UserView {
	static int id;
	UserModel userModel;
	
	public UserView()
	{
		userModel=new UserModel(this);
	}
	
	public void addNewUser()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\n\tenter the user id");
		String id=sc.next();
		
		System.out.print("\n\tenter the Name:");
		String name=sc.next();
		
		System.out.print("\n\tenter the User PhoneNo:");
		String phoneNo=sc.next();
		
		System.out.print("\n\tenter the User mailId:");
		String mailId=sc.next();
		
		System.out.print("\n\tenter the User address:");
		String address=sc.next();
		
		userModel.setUserDetails(id, name, phoneNo, mailId, address);
	
	}
	
	public void addCredentials()
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.print("\n\n\tenter the User Name:");
		String userName=scan.next();
		
		System.out.print("\n\tenter the User PassWord:");
		String password=scan.next();
		
		
		userModel.setCredentials(userName, password);
	}
	
	
	public void alertMse(String altmse)
	{
	   System.out.println("***********"+altmse+"*************");
	   
	}

}
