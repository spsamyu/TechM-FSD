package tasks;

import java.util.*;

public class CollectionAPI {
	public static void main(String[] args) {
		//Add colors to an ArrayList
		List<String> colors = new ArrayList<>(List.of("Red", "Green", "Blue"));
		System.out.println(colors);
		
		//Iterate through an ArrayList
		colors.forEach(System.out::println);
		//Insert element at first position
		colors.add(0, "Yellow");
		//Retrieve an element from a given index
		System.out.println(colors.get(2));
		//Update an element
		colors.set(1, "Purple");
		//Remove the third element
		colors.remove(2);
		//Search for an element
		System.out.println(colors.contains("Green"));
		//Sort an ArrayList
		Collections.sort(colors);
		//Copy an ArrayList
		List<String> copy = new ArrayList<>(colors);
		//Shuffle an ArrayList
		Collections.shuffle(colors);
		
		//Append an element to a LinkedList
		 LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C"));
	        list.addLast("D");
	        System.out.println(list);
	        //Iterate through a LinkedList
	        list.forEach(System.out::println);
	        //Iterate from a specified position
	        Iterator<String> itr = list.listIterator(1);
	        while (itr.hasNext()) System.out.println(itr.next());
	        //Iterate in reverse order
	        Iterator<String> revItr = list.descendingIterator();
	        while (revItr.hasNext()) System.out.println(revItr.next());
	        //Insert at a specified position
	        list.add(2, "X");

	        //Insert at first and last positions
	        list.addFirst("Start");
	        list.addLast("End");

	        //Insert elements at a specified position
	        list.addAll(2, List.of("Y", "Z"));

	        //Get first and last occurrence of an element
	        System.out.println(list.getFirst());
	        System.out.println(list.getLast());




	     












	}
}
