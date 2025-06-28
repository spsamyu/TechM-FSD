package tasks;

public class PrimeSumThread {
	public static void main(String[] args) {
		Thread primeSum = new Thread(() -> {
			int sum = 0;
			for (int i = 2; i < 100; i++) {
				boolean prime = true;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0)
						prime = false;
				}
				if (prime)
					sum += i;
			}
			System.out.println("Sum of primes: " + sum);
		});
		primeSum.start();
	}
}