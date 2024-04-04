package com.naveen.LibraryManagementSystem.userlogin;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;

public class UserLogInModel {
	
	    UserLogInView userLogInView;
	    
	    UserLogInModel(UserLogInView userLogInView)
	    {
	    	this.userLogInView=userLogInView;
	    }
	    
	    
	    public void validateUser(String userName,String passWord)
	    {
	    	   if(validateUserCre(userName,passWord))
	    		{
	    		    userLogInView.alertMse("LogInSuccess Welcome!!");
	    		    userLogInView.onSuccess();
	    		}
	    		else
	    		{
	    			userLogInView.alertMse("InValid Credentials Try Again");
	    	        userLogInView.init();
	    		}
	    }
	    
	
	    private boolean validateUserCre(String userName,String password)
	    {
	        return DataLayer.getInstance().userContains(userName,password);
	    }	
	    
	    

}
