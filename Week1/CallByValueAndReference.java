package Week1;

public class CallByValueAndReference {
	
	// Method that accepts a primitive and a reference (array)
		static void modifyValues(int num, int[] arr) {
			// Modifying the primitive value (passed by value)
			num = 20;

			// Modifying the array elements (passed by reference)
			arr[0] = 100;
			arr[1] = 200;
		}

		public static void main(String[] args) {
			int number = 10;
			int[] array = { 1, 2, 3 };

			// Passing the primitive and reference to the method
			modifyValues(number, array);

			// Printing the values after the method call
			System.out.println("Primitive variable after method call: " + number); // 10 (unchanged)
			System.out.println("Array after method call: ");
			for (int value : array) {
				System.out.print(value + " "); // 100 200 3 (first two modified)
			}
		}

}
