package com.naveen.LibraryManagementSystem.managebooks;

import java.util.*;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.librarysetup.LibrarySetUpView;
import com.naveen.LibraryManagementSystem.model.Book;

public class ManageBookModel {
	
	private ManageBookView manageBookView;
	
	ArrayList <Book> bookList=new ArrayList<>();
	
	Book book;
	
	ManageBookModel(ManageBookView manageBookView)
	{
		this.manageBookView=manageBookView;
		bookList=new ArrayList<>();
		book=new Book();
	}

	
	public void setBookDetails(String bookName,String id,String bookAuthor,int pubYear,String count)
	{
		book.setBookName(bookName);
		book.setBookId(id);
		book.setBookAuthor(bookAuthor);
		book.setPublitionYear(pubYear);
		book.setAvailableCount(count);
	    if(DataLayer.getInstance().addBooks(book))
	    {
	    	manageBookView.alertMse("BOOK ADDED SUCCESSFULLY");
	    	new LibrarySetUpView().setUpCompleted();
	    }
	    else
	    {
	    	manageBookView.alertMse("SOMETHING WRONG TRY AGAIN");
	    	new LibrarySetUpView().init();
	    }
	}
	
	public String removeBook(String id)
	{
		return  DataLayer.getInstance().removeBook(id);
	}
	
	}
	


