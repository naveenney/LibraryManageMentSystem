package com.naveen.LibraryManagementSystem.user;

import java.util.regex.*;


import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.librarysetup.LibrarySetUpView;
import com.naveen.LibraryManagementSystem.model.User;
import com.naveen.LibraryManagementSystem.model.UserCredentials;

class UserModel {
 
	  private UserView userView;
	  private User user;
	  private UserCredentials uc;
	  
	  UserModel(UserView userView)
	  {
		  this.userView=userView;
		  user=new User();
		  uc=new UserCredentials();
	  }
	  
	  public void setUserDetails(String id,String name,String phoneNo,String mailId,String address)
	  {   
		 if(validateUser(id,name,phoneNo,mailId))
		 {
		   user.setId(id);
		   user.setName(name);
		   user.setPhoneNo(phoneNo);
		  user.setMailId(mailId);
		  user.setAddress(address);
		  if(DataLayer.getInstance().insertUserDetails(user))
		  {
			  new UserView().addCredentials();
			  userView.alertMse("USER ADDED SUCCESSFULLY");
			  new LibrarySetUpView().setUpCompleted();
			  
		  }
		 }
	  
	    else
	    {
			  userView.alertMse("Invalid input try again");
			  userView.addNewUser();
	       }
}
	   private boolean validateUser(String id,String name,String phoneNo,String mailId)
	   {
		 if(!validateId(id))
		      return false;
		
	     if(!validateName(name))
	    	 return false;
		 
		if(!validatePhoneNo(phoneNo))
	 
	    if(!isValid(mailId))
	         return false;
	    
	     return true;
}
		private boolean validateName(String name) {
			Pattern p = Pattern.compile("^[A-Z][A-Za-z]{1,20}");
			Matcher m = p.matcher(name);

			return m.matches();

		}

		private boolean validatePhoneNo(String phoneno) {
			Pattern p = Pattern.compile("^[7-9][0-9]{1,9}");
			Matcher m = p.matcher(phoneno);
			return m.matches() & phoneno.length() == 10;
		}


	   private boolean isValid(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
}
	   
	   public void setCredentials(String userName,String password)
	   {
		   if(validateCredentials(userName))
		   {
		    uc.setUserName(userName);
		    uc.setUserPassWord(password);
		   DataLayer.getInstance().addUserCredentials(uc);   
		   }
		   else
		   {
			   userView.alertMse("InValid UserName Try AGAIN!!!");
			   userView.addCredentials();
		   }
	   } 
	   
	   private boolean validateCredentials(String username)
	   {   
		    Pattern p=Pattern.compile("^[A-Za-z]\\w{0,9}$");
		    Matcher m=p.matcher(username);
		    return m.matches();

	   }   
	   
	   private boolean validateId(String id)
	   {
		   return DataLayer.getInstance().CheckUserId(id);
	   }
}