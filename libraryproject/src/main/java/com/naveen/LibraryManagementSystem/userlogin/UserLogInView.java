package com.naveen.LibraryManagementSystem.userlogin;
import java.util.Scanner;
public class UserLogInView {

	UserLogInModel userLogInModel;
	
	public UserLogInView()
	{
		userLogInModel=new UserLogInModel(this);
		
	}
	
	public void init()
	{
		Scanner scan=new Scanner(System.in);
	    
		System.out.print("\n\tenter the userName:");
        String userName=scan.next();
        
        System.out.print("\n\tenter the PassWord:");
        String passWord=scan.next();
        
        userLogInModel.validateUser(userName,passWord);
	}    
       
	public void onSuccess()
	{
	    new com.naveen.LibraryManagementSystem.useroptions.UserLoginView().init(); 	
	}
    public void alertMse(String alt)
    {
    	System.out.println("************"+alt+"***************");
    }
        		
	
	
}
