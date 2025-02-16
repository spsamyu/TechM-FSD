package tasks;

import java.util.List;

public class FindIndex {
	public static <T> int findFirstOccurrence(List<T> list, T target) {
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "apple");
        System.out.println(findFirstOccurrence(words, "apple")); // 0
        System.out.println(findFirstOccurrence(words, "grape")); // -1
    }
}
