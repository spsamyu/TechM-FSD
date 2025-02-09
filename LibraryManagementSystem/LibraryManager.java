package LibraryManagementSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import LibraryManagementSystem.ExceptionHandling.BookNotFoundException;
import LibraryManagementSystem.ExceptionHandling.MaxBooksAllowedException;
import LibraryManagementSystem.ExceptionHandling.UserNotFoundException;

public class LibraryManager extends LibrarySystem {
	private final Map<String, User> userMap = new ConcurrentHashMap<>();
	private final Map<String, Books> bookMap = new ConcurrentHashMap<>();

	public synchronized void addBook(Books book) {
		books.add(book);
		bookMap.put(book.getISBN(), book);
	}

	public synchronized void addUser(User user) {
		users.add(user);
		userMap.put(user.getUserID(), user);
	}

	public synchronized void borrowBook(String ISBN, String userID)
			throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
		User user = userMap.get(userID);
		Books book = bookMap.get(ISBN);

		if (user == null)
			throw new UserNotFoundException("User not found");
		if (book == null)
			throw new BookNotFoundException("Book not found");
		if (user.getBorrowedBooks().size() >= 3)
			throw new MaxBooksAllowedException("Cannot borrow more than 3 books");
		if (book.isBorrowed())
			throw new MaxBooksAllowedException("Book is already borrowed");

		book.setBorrowed(true);
		user.getBorrowedBooks().add(book);
		System.out.println(userID + " borrowed " + book.getTitle());
	}

	public synchronized void returnBook(String ISBN, String userID)
			throws BookNotFoundException, UserNotFoundException {
		User user = userMap.get(userID);
		Books book = bookMap.get(ISBN);

		if (user == null)
			throw new UserNotFoundException("User not found");
		if (book == null)
			throw new BookNotFoundException("Book not found");
		if (!user.getBorrowedBooks().remove(book))
			throw new BookNotFoundException("User didn't borrow this book");

		book.setBorrowed(false);
		System.out.println(userID + " returned " + book.getTitle());
	}

	public Books searchBook(String title) {
		return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
	}
}
