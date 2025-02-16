package tasks;

import java.util.Arrays;

public class SortArrayThread {
	 public static void main(String[] args) {
	        int[] arr = {5, 1, 4, 2, 8};
	        Arrays.parallelSort(arr);
	        System.out.println(Arrays.toString(arr));
	    }
}
