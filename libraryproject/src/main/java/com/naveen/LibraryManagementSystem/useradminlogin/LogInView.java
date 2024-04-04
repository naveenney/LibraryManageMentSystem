package com.naveen.LibraryManagementSystem.useradminlogin;
import java.util.Scanner;
public class LogInView {
	
	LogInModel logInModel;

	public LogInView()
	{
		logInModel=new LogInModel(this);
	}
	
	public void in()
	{
		init();
	}
	public void init()
	{
	  Scanner scan=new Scanner(System.in);	
	  
	  System.out.println("who are you User or admin");
	  String verif=scan.next();
	  
	  
	  logInModel.checkUserOrAdmin(verif);
	  
	}
	
	public void alertMse(String mse)
	{
		System.out.println("************************Welcome User");
	}
	
}
