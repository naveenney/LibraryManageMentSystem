package com.naveen.LibraryManagementSystem.adminlogin;
import com.naveen.LibraryManagementSystem.LibraryManagmentsystem;
import com.naveen.LibraryManagementSystem.login.*;

public class AdminLogInView {


	public void init()
	{
		System.out.println("\n\n\t**********"+LibraryManagmentsystem.getInstance().getAppName()+"**********VERSION:"+LibraryManagmentsystem.getInstance().getAppVersion()+"**********\n");
		new LogInView().initiate();
	}	
		
	public void init1()
	{
		 new com.naveen.LibraryManagementSystem.useradminlogin.LogInView().in();
	}
}
