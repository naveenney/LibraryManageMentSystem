package com.naveen.LibraryManagementSystem;
import com.naveen.LibraryManagementSystem.librarysetup.LibrarySetUpView;
import com.naveen.LibraryManagementSystem.login.*;
public class LibraryManagmentsystem {
					
	        private String appName="Library ManageMent System";
	        private String appVersion="0.0.1";

	        private static LibraryManagmentsystem l;
	        
	        public static LibraryManagmentsystem getInstance()
	        {
	        	if(l==null)
	        	{
	        		l=new LibraryManagmentsystem();
	        	}
	        	return l;
	        }
	        
	        private static void create()
	        {
	        	if(new LogInView().getLibrary()==null)
	        		new LogInView().initiate();
	        	else
	        		new com.naveen.LibraryManagementSystem.useradminlogin.LogInView().init();
	        }
	        public String getAppName()
	        {
	        	return appName;
	        }
	        
	        public String getAppVersion()
	        {
	        	return appVersion;
	        }
	        
			public static void main(String[] args)
			{
				
			    create();
			}
			
			


	}



