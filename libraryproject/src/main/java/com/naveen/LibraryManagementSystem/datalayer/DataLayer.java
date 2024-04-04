package com.naveen.LibraryManagementSystem.datalayer;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naveen.LibraryManagementSystem.model.AdminCredentials;
import com.naveen.LibraryManagementSystem.model.AssignBooks;
import com.naveen.LibraryManagementSystem.model.Book;
import com.naveen.LibraryManagementSystem.model.Library;
import com.naveen.LibraryManagementSystem.model.User;
import com.naveen.LibraryManagementSystem.model.UserCredentials;
import com.naveen.LibraryManagementSystem.useroptions.UserLogInModel;

public class DataLayer {

	private static DataLayer libraryDataLayer;
	private Library library;
	private List<Book> bookList;
	private List<User> userList;
	private AdminCredentials adc;
	private UserCredentials cre;
	private List<UserCredentials> userCredentialsList;
	private List<AssignBooks> assignedBooksToUserList;
	private Date date;
	private AssignBooks assignBooks;
    String booksFile="book.json";
    String libraryFile="library.json";
	private DataLayer() {
		bookList = new ArrayList<>();
		userList = new ArrayList<>();
		adc = new AdminCredentials();
		cre = new UserCredentials();
		userCredentialsList = new ArrayList<>();
		assignedBooksToUserList = new ArrayList<>();
	}

	public static DataLayer getInstance() {
		
		if (libraryDataLayer == null)

			libraryDataLayer = new DataLayer();

		return libraryDataLayer;
	}
    
	public void addAdminCre(String username,String password)
	{
		ObjectMapper obj=new ObjectMapper();
		
		File file=new File("adminCredentials.json");
		
		if(file.exists())
		{
			
		}
	}
	public boolean setAdminCre(String password)
	{
		ObjectMapper obj=new ObjectMapper();
		File file=new File("admincredentials.json");
		try {
		if(!file.exists())
		{
				file.createNewFile();
		        obj.writeValue(file,AdminCredentials.class);
		}
		if(file.exists())
		{
			
				adc=obj.readValue(file,AdminCredentials.class);
				adc.setAdminPassword(password);
				obj.writeValue(file,adc);
				return true;
	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return false;
		
	}
	public boolean validateAdminUserName(String username) {
		return username.equals(adc.getAdminUserName());
	}

	public boolean validateAdminPassWord(String password) {
		return password.equals(adc.getAdminPassWord());
	}

	public void insertLibrary(Library lib)
	{   
		library=lib;
		ObjectMapper obj=new ObjectMapper();
		File file=new File("library.json");
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if(!file.exists())
			try {
				file.createNewFile();
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file,library);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
	}
   
	public Library getLibrary() {
		
		ObjectMapper obj=new ObjectMapper();
		File file=new File("library.json");
		if(file.exists())
		{
			try {
				return obj.readValue(new File(libraryFile),Library.class);
			} catch (Exception e) {
			     e.printStackTrace();
			}
		}
         return null;
		
	}
    
	public boolean addBooks(Book book)
	{
		ObjectMapper obj=new ObjectMapper();
		File file=new File(booksFile);
		try {
		if(!file.exists())
				file.createNewFile();
		
		if(file.exists())
		{
			if(file.length()>0)
			{
				bookList=obj.readValue(file,new TypeReference<List<Book>> () {});
				bookList.add(book);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file,bookList);
				return true;
			}
			else
			{
				bookList.add(book);
				obj.writeValue(file,bookList);
				return true;
			}
			
		}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return false;
		
	}
	public List<Book> showBooks() {
	
	    ObjectMapper obj=new ObjectMapper();
	    File file=new File("book.json");
	    obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	    if(file.exists())
	    {
	    	try {
				return bookList=obj.readValue(file,new TypeReference<List<Book>> () {});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return null;
	    
	}

	public String removeBook(String id) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File("C:book.json");
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	if(file.exists())
		{
		 try {
			bookList=obj.readValue(file,new TypeReference<List<Book>>() {});
			
			 for (Book book : bookList) {
				 System.out.println(book.getId());
					if (book.getId().equals(id)) {
						bookList.remove(book);
						obj.writeValue(file,bookList);
						return "BOOK REMOVED SUCCESSFULLY";
					}
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return "LIST IS EMPTY";
	}

	public void addUserCredentials(UserCredentials cre) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File("credentials.json");
		try {
		if(!file.exists())
		{
				file.createNewFile();
				if(file.exists())
				{
					if(file.length()>0)
					{
			       userCredentialsList=obj.readValue(file,new TypeReference<List<UserCredentials>>() {});		
			       userCredentialsList.add(cre);
			   	obj.enable(SerializationFeature.INDENT_OUTPUT);
			       obj.writeValue(file,userCredentialsList);
				}
					else
					{
						 userCredentialsList.add(cre);
							obj.enable(SerializationFeature.INDENT_OUTPUT);
						 obj.writeValue(file,userCredentialsList);
					}
		      }
		}
			
			
		
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}

	public boolean userContains(String username,String passWord) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File("credentials.json");
		try {
		if(file.exists())
		{
		  if(file.length()>0)
		  {
		   userCredentialsList=obj.readValue(file,new TypeReference<List<UserCredentials>>() {});
		
		for (UserCredentials uc : userCredentialsList) {
			if (uc.userContains(username, passWord)) {
				return true;
			}
		}
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean CheckUserId(String id) {
		for (User user : userList) {
			if (user.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}

	public boolean insertUserDetails(User user) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File("user.json");
		try {
		if(!file.exists())
			
				file.createNewFile();
			
		if(file.exists())
		{
			if(file.length()>0)
			{
			   userList=obj.readValue(file,new TypeReference<List<User>> () {});
			   userList.add(user);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
			   obj.writeValue(file,userList);
			   return true;
			   
			}
			else
			{
				userList.add(user);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file,userList);
				return true;
			}
		}
		
		}
		 catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	public List<User> showUserDetails() {
		
	      ObjectMapper obj=new ObjectMapper();
	      File file=new File("user.json");
	      if(file.exists())
	      {
	    	  if(file.length()>0)
	    	  {
	    		  try {
					return obj.readValue(file,new TypeReference<List<User>> () {});
				} catch (Exception e) {
					e.printStackTrace();
				}
	    	  }
	      }
	      return null;
		
			}

	public void reqBook(String id,String bookName,String bookAuthor) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File("User.json");
        if(file.exists())
        {
        	if(file.length()>0)
        	{
        		try {
					userList=obj.readValue(file,new TypeReference<List<User>>() {});
					for(User user:userList)
					{
						if(user.getId().equals(id))
						{
							if(Integer.parseInt(user.getBookLimit())<=5)
							{
							   assign(user);
							}
							else
							{
								return;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        		
        	}
        }
	}
	
	public void assign(User user)
	{
		ObjectMapper obj=new ObjectMapper();
		
		File file=new File("book.json");
		try {
		if(file.exists())
		{
			if(file.length()>0)
			{
					bookList=obj.readValue(file,new TypeReference<List<Book>> () {});
				    
					for(Book book:bookList)
					{
						if(Integer.parseInt(book.getBookCount())!=0)
						{
							File file1=new File("assignBooks.json");
							if(!file1.exists())
							{
								file1.createNewFile();
							}
							if(file.exists())
							{
								if(file.length()>0)
								{
									assignedBooksToUserList=obj.readValue(file1,new TypeReference<List<AssignBooks>> () {});
									SimpleDateFormat si=new SimpleDateFormat("dd/MM/yyy");
									Date date=si.parse("10/04/24");
									assignBooks.setUser(user);
									assignBooks.setDate(date);
									assignedBooksToUserList.add(assignBooks);
									obj.writeValue(file1,assignedBooksToUserList);
								}
							}
							else
							{
								SimpleDateFormat si=new SimpleDateFormat("dd/MM/yyy");
								Date date=si.parse("10/04/24");
								assignBooks.setUser(user);
								assignBooks.setDate(date);
								assignedBooksToUserList.add(assignBooks);
								obj.writeValue(file1,assignedBooksToUserList);
								
							}
						}
					}
				
				
				
			}
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
	}

	public void showAssignedBooks() {
		for (AssignBooks a : assignedBooksToUserList) {

			System.out.println(a.getUserName() + " " + date);
		}
	}



	public String getAdminUserName() {
		return adc.getAdminUserName();
	}

	public String getAdminPassword() {
		return adc.getAdminPassWord();
	}

	public void setUserPassword(String password) {
		cre.setUserPassWord(password);
	}



	public String getUserPassWord() {
		return cre.getUserPassWord();
	}
}
