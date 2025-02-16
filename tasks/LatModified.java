package tasks;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class LatModified {
	  public static void main(String[] args) {
	        File file = new File("test.txt");
	        System.out.println("Last Modified: " + new Date(file.lastModified()));
	    }

}
