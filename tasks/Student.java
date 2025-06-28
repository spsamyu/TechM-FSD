package tasks;
import java.util.*;


public class Student {
	 String name;
	    int[] marks;
	    int total;
	    double average;
	    Student(String name, int[] marks) {
	        this.name = name;
	        this.marks = marks;
	        this.total = Arrays.stream(marks).sum();
	        this.average = total / (double) marks.length;
	    }

}
