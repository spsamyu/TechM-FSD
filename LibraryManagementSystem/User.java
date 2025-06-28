
package LibraryManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private final String name, userID;
	private final List<Books> borrowedBooks = new ArrayList<>();

	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public List<Books> getBorrowedBooks() {
		return borrowedBooks;
	}

	public String getName() {
		return name;
	}
}
