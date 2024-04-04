
package com.naveen.LibraryManagementSystem.librarysetup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.naveen.LibraryManagementSystem.datalayer.DataLayer;
import com.naveen.LibraryManagementSystem.login.LogInView;
import com.naveen.LibraryManagementSystem.managebooks.ManageBookView;
import com.naveen.LibraryManagementSystem.model.Book;
import com.naveen.LibraryManagementSystem.model.Library;
import com.naveen.LibraryManagementSystem.model.User;

class LibrarySetUpModel extends IOException{

	LibrarySetUpView librarySetUpView;

	private Library library;

	LibrarySetUpModel(LibrarySetUpView librarySetUpView) {
		this.librarySetUpView = librarySetUpView;
	}

	public void startSetUp() {
		if (library == null) {
			library = new Library();
			librarySetUpView.librarySetUp();
		} else
			librarySetUpView.alertMse("\n\t######SetUp Completed######");
			librarySetUpView.setUpCompleted();
	}

	public void setLibraryDetails(String name, String phoneNo, String librarylocation, String mailId) {
		if (validateLibraryDetails(name, phoneNo, mailId)) {
			library.setName(name);

			library.setPhoneNo(phoneNo);

			library.setLocation(librarylocation);

			library.setMailId(mailId);

			DataLayer.getInstance().insertLibrary(library);
		} else
		{
			librarySetUpView.alertMse("\tInvalid TryAgain!!");
		   librarySetUpView.librarySetUp();
		}
	}

	
	public boolean validateLibraryDetails(String name, String phoneno, String mailId) {
		if (!validateName(name))

			return false;

		if (!validatePhoneNo(phoneno))

			return false;

		if (!isValidMailId(mailId))

			return false;

		return true;
	}

	private boolean validateName(String name) {
		Pattern p = Pattern.compile("^[A-Za-z]{0,20}");
		Matcher m = p.matcher(name);

		return m.matches();

	}

	private boolean validatePhoneNo(String phoneno) {
		Pattern p = Pattern.compile("^[7-9][0-9]{1,9}");
		Matcher m = p.matcher(phoneno);
		return m.matches() & phoneno.length() == 10;
	}

	public boolean isValidMailId(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public void removeBook(String id) {
		DataLayer.getInstance().removeBook(id);
	}

	public List<Book> showBook() {
		return DataLayer.getInstance().showBooks();
	}

	public List<User> showUserDetails() {
		return DataLayer.getInstance().showUserDetails();
	}

	public List<Book> searchBooks(String book) {
		return DataLayer.getInstance().showBooks();
	}

	public void setPassWord(String password) {
		if(DataLayer.getInstance().setAdminCre(password))
		{
			librarySetUpView.alertMse("PassWord Changed SuccessFully!!");
			librarySetUpView.setUpCompleted();
		}
		else
		{
			librarySetUpView.alertMse("SOMETHING WRONG TRY AGAIN");
			librarySetUpView.setUpCompleted();
		}

	}

}
