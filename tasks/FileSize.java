package tasks;

import java.io.File;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class FileSize {
	   public static void main(String[] args) throws IOException {
	        File file = new File("test.txt");
	        long bytes = file.length();
	        System.out.println("Bytes: " + bytes + " KB: " + bytes / 1024 + " MB: " + bytes / (1024 * 1024));
	     //  Read file into byte array
	        byte[] bytes1 = Files.readAllBytes(Paths.get("test.txt"));
	        System.out.println(new String(bytes1));
	        
	        //Read file content line by line
	        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        //Read plain text file
	        List<String> lines = Files.readAllLines(Paths.get("test.txt"));
	        lines.forEach(System.out::println);
	    }
	    }

