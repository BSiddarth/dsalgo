package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String text = "abcabcbb";
        int length = lengthOfLongestSubstring(text);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }

    // Function to find the length of the longest substring without repeating characters
    public static int lengthOfLongestSubstring(String text) {
        int n = text.length();
        int maxLength = 0; // Variable to track the maximum length of substring without repeats

        // HashMap to store the last index of each character
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        // Sliding window pointers
        int i = 0, j = 0; // Start (i) and end (j) of the window

        // Sliding the window until the end of the text
        while (j < n) {
            char currentChar = text.charAt(j);

            // If the character is already in the map and is within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= i) {
                // Move the start of the window to the right of the previous occurrence of currentChar
                i = charIndexMap.get(currentChar) + 1;
            }

            // Update the last seen index of the current character
            charIndexMap.put(currentChar, j);

            // Calculate the length of the current window and update maxLength if needed
            maxLength = Math.max(maxLength, j - i + 1);

            // Move the end of the window
            j++;
        }
        
        return maxLength;
    }
}


/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Remove characters until there are no duplicates
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}*/



/*
Let's dry run the code for the input string "abcabcbb" to understand how it finds the longest substring without repeating characters.

Initialization
Input: text = "abcabcbb"
Variables:
n = 8 (length of the string)
maxLength = 0
charIndexMap = {} (initially empty)
i = 0 (start of the window)
j = 0 (end of the window)
Iteration Steps
Step-by-Step Execution with while (j < n)
First Iteration (j = 0):

currentChar = text.charAt(j) = 'a'
'a' is not in charIndexMap, so there's no need to adjust i.
Update charIndexMap with {'a': 0}.
Calculate the current substring length: j - i + 1 = 1.
Update maxLength = max(0, 1) = 1.
Increment j to 1.
Second Iteration (j = 1):

currentChar = text.charAt(j) = 'b'
'b' is not in charIndexMap, so there's no need to adjust i.
Update charIndexMap with {'a': 0, 'b': 1}.
Calculate the current substring length: j - i + 1 = 2.
Update maxLength = max(1, 2) = 2.
Increment j to 2.
Third Iteration (j = 2):

currentChar = text.charAt(j) = 'c'
'c' is not in charIndexMap, so there's no need to adjust i.
Update charIndexMap with {'a': 0, 'b': 1, 'c': 2}.
Calculate the current substring length: j - i + 1 = 3.
Update maxLength = max(2, 3) = 3.
Increment j to 3.
Fourth Iteration (j = 3):

currentChar = text.charAt(j) = 'a'
'a' is in charIndexMap at index 0, which is within the current window (i = 0 to j = 3).
Move i to charIndexMap.get('a') + 1 = 0 + 1 = 1 to avoid repeating 'a'.
Update charIndexMap with {'a': 3, 'b': 1, 'c': 2}.
Calculate the current substring length: j - i + 1 = 3.
maxLength remains 3 (no change).
Increment j to 4.
Fifth Iteration (j = 4):

currentChar = text.charAt(j) = 'b'
'b' is in charIndexMap at index 1, which is within the current window (i = 1 to j = 4).
Move i to charIndexMap.get('b') + 1 = 1 + 1 = 2.
Update charIndexMap with {'a': 3, 'b': 4, 'c': 2}.
Calculate the current substring length: j - i + 1 = 3.
maxLength remains 3 (no change).
Increment j to 5.
Sixth Iteration (j = 5):

currentChar = text.charAt(j) = 'c'
'c' is in charIndexMap at index 2, which is within the current window (i = 2 to j = 5).
Move i to charIndexMap.get('c') + 1 = 2 + 1 = 3.
Update charIndexMap with {'a': 3, 'b': 4, 'c': 5}.
Calculate the current substring length: j - i + 1 = 3.
maxLength remains 3 (no change).
Increment j to 6.
Seventh Iteration (j = 6):

currentChar = text.charAt(j) = 'b'
'b' is in charIndexMap at index 4, which is within the current window (i = 3 to j = 6).
Move i to charIndexMap.get('b') + 1 = 4 + 1 = 5.
Update charIndexMap with {'a': 3, 'b': 6, 'c': 5}.
Calculate the current substring length: j - i + 1 = 2.
maxLength remains 3 (no change).
Increment j to 7.
Eighth Iteration (j = 7):

currentChar = text.charAt(j) = 'b'
'b' is in charIndexMap at index 6, which is within the current window (i = 5 to j = 7).
Move i to charIndexMap.get('b') + 1 = 6 + 1 = 7.
Update charIndexMap with {'a': 3, 'b': 7, 'c': 5}.
Calculate the current substring length: j - i + 1 = 1.
maxLength remains 3 (no change).
Increment j to 8, which ends the loop.
Final Result
The longest substring without repeating characters is "abc" with a length of 3.
Output: maxLength = 3
The final result matches the expected outcome, as "abc" (or any of the other substrings of length 3 like "bca", "cab") are the longest substrings without repeating characters in "abcabcbb".*/
