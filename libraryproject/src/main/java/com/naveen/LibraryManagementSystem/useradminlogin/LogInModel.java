package com.naveen.LibraryManagementSystem.useradminlogin;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.model.User;
import com.naveen.LibraryManagementSystem.userlogin.UserLogInView;
public class LogInModel {
	
	LogInView logInView;
	User user;
	
	LogInModel(LogInView logInView)
	{
	    this.logInView=logInView;	
	}	
    
    
	public void checkUserOrAdmin(String ver)
	{
		if(ver.equals("User"))
		{  
			logInView.alertMse(ver);
			new UserLogInView().init();
			
		}
		else if(ver.equals("Admin"))	
		{
		    new com.naveen.LibraryManagementSystem.login.LogInView().initiate();
		}
		
	}

	
}
