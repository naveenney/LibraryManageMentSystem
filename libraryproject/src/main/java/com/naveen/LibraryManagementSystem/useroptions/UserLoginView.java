package com.naveen.LibraryManagementSystem.useroptions;
import java.util.Scanner;

import com.naveen.LibraryManagementSystem.librarysetup.LibrarySetUpView;
public class UserLoginView {
 
	UserLogInModel userLogInModel;
	LibrarySetUpView librarySetupview;
	public UserLoginView()
	{
		userLogInModel=new UserLogInModel(this);
		librarySetupview=new LibrarySetUpView();
	}
	
	public void init()
	{
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("\n\tPress 1 => show books"+"\n\tPress 2 => search books"+"\n\t Press 3 => Request Book"+"\n\tPress 4 => Show Assigned Books"+"\n\tPress 5 => 5Change Password"+"\n\tPress 6 => Log out");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
			   librarySetupview.showBooks();
			   break;
			case 2:
				System.out.println("\n\tEnter the Book Name:");
				String bookName=scan.next();
				librarySetupview.searchBooks(bookName);
				break;
			case 3:
				System.out.print("\n\tEnter your user Id:");
				String id=scan.next();
				System.out.print("Enter the bookName:");
				String bookname=scan.next();
				System.out.print("\n\tEnter the bookAuthor:");
				String author=scan.next();
				userLogInModel.bookRequest(id,bookname,author);
				break;
				
			case 4:
				userLogInModel.showAssignedBooks();
				break;
				
		   	case 5:
				System.out.println("enter the password:");
		        String password=scan.next();	
		     //   userLogInModel.setPassWord(password);
		        break;
		        
		   	case 6:
		   		flag=false;
		   		librarySetupview.setUpCompleted();
		   		break;
		        
		}
		
		
	}
	
	}
	
	public void alertMse(String mse)
	{
		System.out.println(mse);
	}
}
