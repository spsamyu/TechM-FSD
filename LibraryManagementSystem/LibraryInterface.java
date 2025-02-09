package LibraryManagementSystem;

import LibraryManagementSystem.ExceptionHandling.BookNotFoundException;
import LibraryManagementSystem.ExceptionHandling.MaxBooksAllowedException;
import LibraryManagementSystem.ExceptionHandling.UserNotFoundException;

interface LibraryInterface {
    void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException;
    void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException;
    Books searchBook(String title);
}
