package tasks;

import java.io.File;
import java.io.FileNotFoundException;

class FileNotFoundDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("test.txt");
        if (!file.exists()) throw new FileNotFoundException("File not found");
    }
}