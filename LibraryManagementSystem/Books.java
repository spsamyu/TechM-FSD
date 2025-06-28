package LibraryManagementSystem;

import java.io.Serializable;

class Books implements Serializable {
	private final String title, author, ISBN;
	private boolean isBorrowed;

	public Books(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.isBorrowed = false;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean status) {
		isBorrowed = status;
	}

	public String getAuthor() {
		return author;
	}
}
