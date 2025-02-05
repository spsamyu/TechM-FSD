package Week1;

public class OperationsUsingString {
	// Method to reverse the given string
    public static String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder(str);
        return reversedString.reverse().toString();
    }

    // Method to count occurrences of a substring within the given text
    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    // Method to split the string by spaces and capitalize each word
    public static String splitAndCapitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder capitalizedString = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedString.append(word.substring(0, 1).toUpperCase())
                                  .append(word.substring(1).toLowerCase())
                                  .append(" ");
            }
        }
        // Removing the last extra space
        return capitalizedString.toString().trim();
    }

    public static void main(String[] args) {
        String text = "hello world, hello universe";
        String str = "java programming is fun";

        // Testing reverseString method
        System.out.println("Reversed String: " + reverseString(str));

        // Testing countOccurrences method
        System.out.println("Occurrences of 'hello': " + countOccurrences(text, "hello"));

        // Testing splitAndCapitalize method
        System.out.println("Capitalized String: " + splitAndCapitalize(str));
    }

}
