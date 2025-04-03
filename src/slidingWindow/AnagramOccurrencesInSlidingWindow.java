package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class AnagramOccurrencesInSlidingWindow {

    public static void main(String[] args) {
        // Input string and the pattern to check for anagrams
        String text = "cbaebabacd";
        String pattern = "abc";

        // Find and print the count of anagrams of the pattern in the text
        int count = countAnagramOccurrences(text, pattern);
        System.out.println("Number of anagram occurrences: " + count);
    }

    // Function to count the occurrences of anagrams of the pattern in the text
    public static int countAnagramOccurrences(String text, String pattern) {
        int k = pattern.length(); // Window size (length of the pattern)
        int n = text.length(); // Length of the input text

        if (k > n) return 0; // Edge case: if the pattern is longer than the text

        // Create frequency maps for the pattern and the current window
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Fill the frequency map for the pattern
        for (char ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // Variables to track the count of anagram occurrences
        int count = 0;

        // Sliding window over the text
        int i = 0, j = 0;
        while (j < n) {
            // Add current character to the window frequency map
            char currentChar = text.charAt(j);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
            // If the window size is less than the pattern size, just expand the window
            if (j - i + 1 < k) {
                j++;
            }
            // Once the window size is equal to the pattern size
            else if (j - i + 1 == k) {
                // Check if the current window is an anagram of the pattern
                if (windowMap.equals(patternMap)) {
                    count++;
                }
                // Slide the window: remove the character at the start of the window
                char startChar = text.charAt(i);
                windowMap.put(startChar, windowMap.get(startChar) - 1);
                // If the frequency becomes 0, remove the character from the map
                if (windowMap.get(startChar) == 0) {
                    windowMap.remove(startChar);
                }
                // Slide the window forward
                i++;
                j++;
            }
        }
        return count;
    }
}

