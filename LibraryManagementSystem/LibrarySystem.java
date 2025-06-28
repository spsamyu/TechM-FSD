package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

abstract class LibrarySystem implements LibraryInterface {
	protected final List<Books> books = new ArrayList<>();
	protected final List<User> users = new ArrayList<>();

	public abstract void addBook(Books book);

	public abstract void addUser(User user);
}