package tasks;

import java.util.Arrays;

public class ArrayCopyRangeDemo {
	 public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5, 6};
	        int[] newArr = Arrays.copyOfRange(arr, 1, 4);
	        System.out.println(Arrays.toString(newArr));
	    }
}
