package Dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String a = "babad";

        // Initialize the maximum length of palindromic substring found so far
        int maxLength = 1;

        // Store the starting index of the longest palindromic substring
        int start = 0;

        // Loop through each character in the string, treating it as a potential center
        for (int i = 0; i < a.length(); i++) {

            // Check for odd-length palindromic substring centered at 'i'
            int left = i - 1;
            int right = i + 1;

            // Expand around the center (odd-length palindrome)
            while (left >= 0 && right < a.length() && a.charAt(left) == a.charAt(right)) {

                // Update maxLength and start if a longer palindrome is found
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }

                // Move pointers outward to expand the palindrome
                left--;
                right++;
            }

            // Check for even-length palindromic substring centered between 'i' and 'i+1'
            left = i;
            right = i + 1;

            // Expand around the center (even-length palindrome)
            while (left >= 0 && right < a.length() && a.charAt(left) == a.charAt(right)) {

                // Update maxLength and start if a longer palindrome is found
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }

                // Move pointers outward to expand the palindrome
                left--;
                right++;
            }
        }

        // Extract the longest palindromic substring based on calculated start and maxLength
        String longestPalindrome = a.substring(start, start + maxLength);

        // Print the result
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}


/*
Let's dry-run the code with input a = "babad" to see how it identifies the longest palindromic substring.

Initial Setup
Input string a = "babad"
Variables:
maxLength = 1 (to store the length of the longest palindrome found so far)
start = 0 (to store the starting index of the longest palindrome)
Iteration 1 (i = 0)
Odd-length palindrome check:

left = i - 1 = -1
right = i + 1 = 1
The while condition left >= 0 && right < a.length() && a.charAt(left) == a.charAt(right) fails because left is -1.
Even-length palindrome check:

left = i = 0
right = i + 1 = 1
The while condition fails because a.charAt(left) != a.charAt(right) ('b' != 'a').
Result after Iteration 1:

maxLength = 1, start = 0
Iteration 2 (i = 1)
Odd-length palindrome check:

left = i - 1 = 0, right = i + 1 = 2
        a.charAt(left) == a.charAt(right) ('b' == 'b'), so:
Update maxLength = right - left + 1 = 3
Update start = left = 0
        Decrement left = -1, increment right = 3
The while condition fails because left = -1.
Even-length palindrome check:

left = i = 1, right = i + 1 = 2
The while condition fails because a.charAt(left) != a.charAt(right) ('a' != 'b').
Result after Iteration 2:

maxLength = 3, start = 0
Longest palindromic substring found so far: "bab"
Iteration 3 (i = 2)
Odd-length palindrome check:

left = i - 1 = 1, right = i + 1 = 3
        a.charAt(left) == a.charAt(right) ('a' == 'a'), so:
maxLength remains 3 (no update because current palindrome length is also 3)
start remains 0
        Decrement left = 0, increment right = 4
The while condition fails because a.charAt(left) != a.charAt(right) ('b' != 'd').
Even-length palindrome check:

left = i = 2, right = i + 1 = 3
The while condition fails because a.charAt(left) != a.charAt(right) ('b' != 'a').
Result after Iteration 3:

maxLength = 3, start = 0
Longest palindromic substring remains: "bab"
Iteration 4 (i = 3)
Odd-length palindrome check:

left = i - 1 = 2, right = i + 1 = 4
        a.charAt(left) == a.charAt(right) ('b' == 'd'), so the while loop doesn’t execute.
Even-length palindrome check:

left = i = 3, right = i + 1 = 4
The while condition fails because a.charAt(left) != a.charAt(right) ('a' != 'd').
Result after Iteration 4:

maxLength = 3, start = 0
Longest palindromic substring remains: "bab"
Iteration 5 (i = 4)
Odd-length palindrome check:

left = i - 1 = 3, right = i + 1 = 5
The while loop doesn’t execute because right = 5 is out of bounds.
Even-length palindrome check:

left = i = 4, right = i + 1 = 5
The while loop doesn’t execute because right = 5 is out of bounds.
Result after Iteration 5:

maxLength = 3, start = 0
Longest palindromic substring remains: "bab"
Final Output
After all iterations:

The longest palindromic substring has length 3 and starts at index 0.
The substring is a.substring(start, start + maxLength) = a.substring(0, 3) = "bab".

*/
