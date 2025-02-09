package LibraryManagementSystem;

import java.io.Serializable;

// Class representing a book in the library
class Books implements Serializable {
	private final String title, author, ISBN;
	private boolean isBorrowed;

	// Constructor to initialize book details
	public Books(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.isBorrowed = false; // Default status: not borrowed
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	// Method to check if the book is borrowed
	public boolean isBorrowed() {
		return isBorrowed;
	}

	// Method to update the book's borrowed status
	public void setBorrowed(boolean status) {
		isBorrowed = status;
	}

	public String getAuthor() {
		return author;
	}
}
