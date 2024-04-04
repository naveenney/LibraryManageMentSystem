package com.naveen.LibraryManagementSystem.login;
import java.util.*;

import com.naveen.LibraryManagementSystem.librarysetup.LibrarySetUpView;
import com.naveen.LibraryManagementSystem.model.Library;
public class LogInView {
	

	private LogInModel logInModel;

	public LogInView() {
		logInModel = new LogInModel(this);
	}

    public void initiate()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\tenter the UserName:");
		String userName=sc.next();
		
		System.out.print("\n\tenter the password:");
		String passWord=sc.next();
		
		
		logInModel.validateUser(userName,passWord);
		
	}
	
    public void onSuccess()
    {
    	if(getLibrary()==null)
          new LibrarySetUpView().init();
    	else
    	  new LibrarySetUpView().setUpCompleted();	
    }
    
	public void alertMse(String alertMse)
	{
		System.out.println("\n"+alertMse);
	}
	
	public Library getLibrary()
	{
		return logInModel.getLibrary();
	} 

}
