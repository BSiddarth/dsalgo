package hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsecutiveSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Step 1: Create a hash (Set in Java)
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2-6: Iterate over each element to find the longest sequence
        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Subsequence Length: " + findLongestConsecutiveSubsequence(arr));
    }
}
