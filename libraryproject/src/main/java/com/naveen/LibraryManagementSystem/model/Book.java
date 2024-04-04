package com.naveen.LibraryManagementSystem.model;

public class Book {
	
	String bookId;
	
	String bookName;

	String bookAuthor;

	int publitionYear;

	String availableCount;

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookId(String id) {
		bookId = id;
	}

	public void setBookAuthor(String author) {
		bookAuthor = author;
	}

	public void setPublitionYear(int pubYear) {
		this.publitionYear = pubYear;
	}

	public void setAvailableCount(String count) {
		availableCount = count;
	}

	public String getBookName() {
		return bookName;
	}

	public String getId() {
		return bookId;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public int getPublitionYear() {
		return publitionYear;
	}

	public String getBookCount() {
		return availableCount;
	}

}