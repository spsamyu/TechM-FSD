package tasks;

public class CheckOdd {
	public static void checkNumber(int num) throws OddNumberException {
        if (num % 2 != 0) throw new OddNumberException("Odd number not allowed");
    }
}
