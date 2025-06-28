package Week1;

import java.util.Scanner;

public class ExceptionalHandling {
	public static void processInput() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter a number: ");
			double number = scanner.nextDouble();

			if (number == 0) {
				throw new ArithmeticException("Reciprocal of zero is undefined.");
			}

			System.out.println("Reciprocal: " + (1 / number));
		} catch (ArithmeticException e) { // Catch division by zero separately
			System.out.println(e.getMessage());
		} catch (Exception e) { // Catch all other exceptions
			System.out.println("Invalid input! Please enter a valid number.");
		} finally {
			scanner.close();
		}
	}

	public static void main(String[] args) {
		processInput();
	}

}
