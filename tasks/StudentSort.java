package tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentSort {
	 public static void main(String[] args) {
	        List<Student> students = Arrays.asList(
	            new Student("Alice", new int[]{80, 90, 70}),
	            new Student("Bob", new int[]{85, 60, 75})
	        );
	        students.sort(Comparator.comparingInt(s -> -s.total));
	        students.forEach(s -> System.out.println(s.name + " " + s.total + " " + s.average));
	    }

}
