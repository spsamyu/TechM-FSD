package tasks;

import java.io.File;

public class CheckPermissions {
	public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
