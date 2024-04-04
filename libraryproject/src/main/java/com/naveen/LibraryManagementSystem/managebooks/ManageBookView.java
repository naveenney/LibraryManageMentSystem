package com.naveen.LibraryManagementSystem.managebooks;

import java.util.Scanner;

public class ManageBookView {
	
	private ManageBookModel manageBookModel;
	
	public ManageBookView()
	{
		manageBookModel=new ManageBookModel(this);
		
	}

	
	public void addBooks()
	{
	    Scanner sc=new Scanner(System.in);
	    
	    System.out.print("\n\tenter the bookName:");
	    String bookName=sc.next();
	    
	    System.out.print("\n\tenter the BookID:");
	    String id=sc.next();
	    
	    System.out.print("\n\tenter the Book author:");
	    String author=sc.next();
	    
	    System.out.print("\n\tenter the publition year:");
	    int pubYear=sc.nextInt();
	    
	    System.out.print("\n\tenter the book Count:");
	    String count=sc.next();
	    System.out.println("");
	    manageBookModel.setBookDetails(bookName, id, author, pubYear ,count);
	    
	}
    
	public void removeBook(String id)
	{
		alertMse(manageBookModel.removeBook(id));
	}
	public void alertMse(String mse)
	{
		System.out.println("*******"+mse+"*******");
	}
	

}
