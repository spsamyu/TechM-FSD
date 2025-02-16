package tasks;
import java.util.List;
import java.util.Optional;

public class MinMaxFinder {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 20, 25, 15);

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);

        System.out.println("Minimum value: " + min.orElseThrow());
        System.out.println("Maximum value: " + max.orElseThrow());
    }
}

