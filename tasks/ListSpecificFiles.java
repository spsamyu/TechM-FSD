package tasks;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ListSpecificFiles {
	public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

}
