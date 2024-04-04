package com.naveen.LibraryManagementSystem.login;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.model.Library;

public class LogInModel {
	
     LogInView logInView;
	
	LogInModel(LogInView logInView)
	{
		this.logInView=logInView;
	}
	
	public void validateUser(String userName,String passWord)
	{
		if(validateUserName(userName))
			if(validatePassWord(passWord))
			{
				logInView.alertMse("\t****LOGIN SUCCESSFULLY****");
		        logInView.onSuccess();
			}
			else
			{
				logInView.alertMse("passWord Wrong try again");
		        logInView.initiate();
			}
		else
		{
			logInView.alertMse("InvalidUSerName");
			logInView.initiate();
		}
	}
	
	private boolean validateUserName(String userName)
	{
	     return DataLayer.getInstance().validateAdminUserName(userName);	
	}
	
	private boolean validatePassWord(String passWord)
	{
		return DataLayer.getInstance().validateAdminPassWord(passWord);
	}
    
	public Library getLibrary()
	{
	   return DataLayer.getInstance().getLibrary();	
	}
}
