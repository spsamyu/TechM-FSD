package tasks;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class ListFiles {
	
	 public static void main(String[] args) {
	        File dir = new File(".");
	        String[] files = dir.list();
	        if (files != null) {
	            for (String file : files) {
	                System.out.println(file);
	            }
	        }
	    }
}
