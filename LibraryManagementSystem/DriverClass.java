package LibraryManagementSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverClass {
    public static void main(String[] args) {
        // Create a library manager instance
        LibraryManager library = new LibraryManager();

        // Add books to the library
        library.addBook(new Books("Core Java", "ABC", "ISBN123"));
        library.addBook(new Books("Data Structures", "XYZ", "ISBN456"));

        // Add users to the library system
        library.addUser(new User("Sam", "User1"));
        library.addUser(new User("Priyo", "User2"));

        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Execute book borrowing operation in a separate thread
        executor.execute(() -> {
            try { library.borrowBook("ISBN123", "User11"); } 
            catch (Exception e) { System.out.println(e.getMessage()); }
        });

        // Execute book and return operation in another thread
        executor.execute(() -> {
            try { library.returnBook("ISBN123", "User1"); } 
            catch (Exception e) { System.out.println(e.getMessage()); }
        });
        executor.shutdown();
    }
}
