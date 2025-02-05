package Week1;
import java.util.*;

public class AnagramFinder {
	
	// Method to find all the starting indices of the anagrams of p in s
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // Create frequency map for string p
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        // Create a map for the current sliding window in s
        Map<Character, Integer> sMap = new HashMap<>();
        int pLength = p.length();
        int sLength = s.length();

        // Initialize the sliding window
        for (int i = 0; i < pLength; i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        // Check if the first window is an anagram
        if (sMap.equals(pMap)) {
            result.add(0);
        }

        // Slide the window across s
        for (int i = pLength; i < sLength; i++) {
            // Add the new character to the window
            char newChar = s.charAt(i);
            sMap.put(newChar, sMap.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the window
            char oldChar = s.charAt(i - pLength);
            sMap.put(oldChar, sMap.get(oldChar) - 1);
            if (sMap.get(oldChar) == 0) {
                sMap.remove(oldChar);
            }

            // Check if the current window is an anagram
            if (sMap.equals(pMap)) {
                result.add(i - pLength + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);

        System.out.println("Anagram indices: " + result);
    }

}
