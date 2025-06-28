
package LibraryManagementSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DriverClass {
	public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addBook(new Books("Core Java", "ABC", "ISBN123"));
        library.addBook(new Books("Data Structures", "XYZ", "ISBN456"));
        library.addUser(new User("Sam", "User1"));
        library.addUser(new User("Priyo", "User2"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try { library.borrowBook("ISBN123", "User11"); } catch (Exception e) { System.out.println(e.getMessage()); }
        });
        executor.execute(() -> {
            try { library.returnBook("ISBN123", "User1"); } catch (Exception e) { System.out.println(e.getMessage()); }
        });
        executor.shutdown();
    }

}
