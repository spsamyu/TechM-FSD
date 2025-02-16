package tasks;

import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {
    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "cherry", "apricot");

        List<String> ascending = words.stream().sorted().collect(Collectors.toList());
        List<String> descending = words.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

        System.out.println("Ascending order: " + ascending);
        System.out.println("Descending order: " + descending);
    }
}

