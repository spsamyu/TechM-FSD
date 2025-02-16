package tasks;

import java.util.Arrays;

public class GenericArrayCheck {
	public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        Integer[] arr3 = {1, 3, 2};

        System.out.println(areArraysEqual(arr1, arr2)); // true
        System.out.println(areArraysEqual(arr1, arr3)); // false
    }
}
