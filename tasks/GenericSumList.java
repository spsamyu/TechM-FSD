package tasks;

import java.util.List;

public class GenericSumList {
    public static <T extends Number> int sumEvenOdd(List<T> list, boolean even) {
        return list.stream().mapToInt(Number::intValue).filter(n -> (n % 2 == 0) == even).sum();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Sum of evens: " + sumEvenOdd(numbers, true));  // 12
        System.out.println("Sum of odds: " + sumEvenOdd(numbers, false)); // 9
    }

}
