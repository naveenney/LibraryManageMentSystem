package com.naveen.LibraryManagementSystem.useroptions;

import java.util.List;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.model.Book;

public class UserLogInModel {
	
	private UserLoginView userLogInView;

	
	UserLogInModel(UserLoginView userLogInView)
	{
		this.userLogInView=userLogInView;
	}
	
	public void bookRequest(String id,String name,String author)
	{
       if(DataLayer.getInstance().reqBook(id,name,author))
    	   userLogInView.alertMse("\n\t***********your Request Is accepted***********");
           
       else
    	   userLogInView.alertMse("\n\t***********Sorry You Are Already Reached your BookLimit************");
           userLogInView.init();
	}
	
	public void showAssignedBooks()
	{
		DataLayer.getInstance().showAssignedBooks();
	}

	
	
	
	

}
