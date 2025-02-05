package utility;

public class Utility {
	// Static method to find the length of an integer
		public static int getLength(int number) {
			// Convert the number to a string and return its length
			return String.valueOf(Math.abs(number)).length();
		}
}
