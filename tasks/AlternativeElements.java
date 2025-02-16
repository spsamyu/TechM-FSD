package tasks;

import java.util.Scanner;

public class AlternativeElements {

	public static void main(String[] args) {
		

		int[] elements= {1,4,6,7,8,3};
		for(int i=0;i<elements.length-1;i++) {
			
				System.out.println(elements[i+1]);
				i=i+1;
			
		}
		

	}

}
