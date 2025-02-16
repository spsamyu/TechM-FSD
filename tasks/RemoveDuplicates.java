package tasks;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 3, 5, 6, 7, 5);

        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}
