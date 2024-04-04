package com.naveen.LibraryManagementSystem.librarysetup;

import java.util.List;
import java.util.Scanner;

import com.naveen.LibraryManagementSystem.adminlogin.AdminLogInView;
import com.naveen.LibraryManagementSystem.managebooks.ManageBookView;
import com.naveen.LibraryManagementSystem.model.Book;
import com.naveen.LibraryManagementSystem.model.Library;
import com.naveen.LibraryManagementSystem.model.User;
import com.naveen.LibraryManagementSystem.user.UserView;

public class LibrarySetUpView {
	
	private LibrarySetUpModel librarySetUpModel;
	
	public LibrarySetUpView()
	{
		librarySetUpModel=new LibrarySetUpModel(this);
	}
	
	public void init()
	{
		librarySetUpModel.startSetUp();
		
		}
	
	
	
	public void librarySetUp()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\n\tenter the LibraryName:");
		String libraryName=sc.next();
		
		System.out.print("\n\tenter the library phoneno:");
		String phoneNo=sc.next();
		
		System.out.print("\n\tenter the LibraryLocation:");
		String libraryLocation=sc.next();
		
		System.out.print("\n\tnenter the mail id:");
		String libraryMailId=sc.next();
		
	    librarySetUpModel.setLibraryDetails(libraryName,phoneNo,libraryLocation, libraryMailId);
		librarySetUpModel.startSetUp();
	}	
		
	public void setUpCompleted()
	{
		Scanner sc=new Scanner(System.in);
		
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("\n\tPress 1 => addBooks\n\n\t"+"\n\tPress 2 => removeBooks\n\n\t"+"\n\n\tPress 3 => showBooks\n\t"+"\n\n\tPress 4 => add new user\n\t"+"\n\n\tPress 5 => show USer Details\n\t"+"\n\n\tPress 6 => search Books\n\t"+"\n\n\t7Press 7 => change password\n\t"+"\n\n\tPress 8 => Log out\n\t");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				new ManageBookView().addBooks();;
				break;
			case 2:
				System.out.print("\tenter the BookId to remove:");
				String id=sc.next();
			    new ManageBookView().removeBook(id);
			    break;
			case 3:
                  showBooks();			
			      break;
			case 4:
				  new UserView().addNewUser();
				  new UserView().addCredentials();
				  break;
			case 5:
			      showUserDetails();
				  break;
			case 6:	
				 System.out.print("\tenter the book name:");
				 String bookName=sc.next();
				 searchBooks(bookName);
 				 break;
			case 7:
				System.out.print("\tenter the new PassWord:");
				String password=sc.next();
				librarySetUpModel.setPassWord(password);
	            break;
			case 8:
				
				 flag=false;
				 new AdminLogInView().init1();
					break;
	          
			}
		}
	}
	
	public void showBooks()
	{
		List <Book> list=librarySetUpModel.showBook();
		
		if(list!=null)
		{
		for(Book book:list)
		{
			System.out.println("\n\tBOOK ID:"+book.getId()+"\n\tBOOK NAME:"+book.getBookName()+"\n\tBOOK AUTHOR:"+book.getBookAuthor()+"\n\tBOOK PUB YEAR:"+book.getPublitionYear()+"\n\tBOOK COUNT:"+book.getBookCount());
		}
		}
		else
		   System.out.println("NO BOOKS AVAILABLE IN THE DATABASE");
	}
	public void alertMse(String mse)
	{
		System.out.println("\n\t"+mse);
	}
	
	public void searchBooks(String bookName)
	{
		List <Book> list=librarySetUpModel.showBook();
		if(list!=null)
		for(Book book:list)
		{
		    if(book.getBookName().contains(bookName))
		    {
		    	System.out.println("\n\tBOOK ID:"+book.getId()+"\n\tBOOK NAME:"+book.getBookName()+"\n\tBOOK AUTHOR:"+book.getBookAuthor()+"\n\nBOOK PUB YEAR:"+book.getPublitionYear()+"\n\tBOOK COUNT:"+book.getBookCount());

		    }
		}
		
		else {
			System.out.println("NO BOOKS AVAILABLE IN THE DATABASE");
		}
			
	}	
	
	public void showUserDetails()
	{
		List<User> userList=librarySetUpModel.showUserDetails();
		if(userList!=null)
		{
		for(User user:userList)
		{
			System.out.println("\n\nUSER ID:"+user.getId()+"\n\tUSER NAME:"+user.getName()+"\n\tUSER PHONE NO:"+user.getphoneNo()+"\n\tUSER MAIL ID:"+user.getMailId()+"\n\tUSER BOOKLIMIT:"+user.getBookLimit());
			
		}
		}
		else
			System.out.println("NO USER AVAILABLE IN THE DATABASE");
		
		
	}
			
	
	
}
