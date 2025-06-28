package LibraryManagementSystem;

public class ExceptionHandling {
	static class BookNotFoundException extends Exception {
		public BookNotFoundException(String message) {
			super(message);
		}
	}

	static class UserNotFoundException extends Exception {
		public UserNotFoundException(String message) {
			super(message);
		}
	}

	static class MaxBooksAllowedException extends Exception {
		public MaxBooksAllowedException(String message) {
			super(message);
		}
	}

}
