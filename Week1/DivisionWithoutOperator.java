package Week1;

public class DivisionWithoutOperator {
	// Method to perform division using only '+' and '-'
    public static void divideNumbers(int dividend, int divisor) {
        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        int quotient = 0;
        int remainder = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        boolean isNegative = (dividend < 0) ^ (divisor < 0); // Determine if the result should be negative

        // Subtract divisor from dividend repeatedly until remainder is less than divisor
        while (remainder >= absDivisor) {
            remainder -= absDivisor;
            quotient++;
        }

        // Adjust sign of quotient if necessary
        quotient = isNegative ? -quotient : quotient;
        remainder = dividend < 0 ? -remainder : remainder;

        // Print results
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }

    public static void main(String[] args) {
        int dividend = 16, divisor = 5;
        divideNumbers(dividend, divisor); // Expected output: Quotient: 5, Remainder: 2
    }


}
