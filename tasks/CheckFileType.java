package tasks;

import java.io.File;

public class CheckFileType {
	  public static void main(String[] args) {
	        File file = new File("test.txt");
	        if (file.isDirectory()) System.out.println("Directory");
	        else if (file.isFile()) System.out.println("File");
	        else System.out.println("Not found");
	    }
}
