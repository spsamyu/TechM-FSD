package tasks;

import java.io.File;

public class CheckExists {
	public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println(file.exists() ? "Exists" : "Does not exist");
    }
}
