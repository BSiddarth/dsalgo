package Dp;


import java.util.HashMap;
import java.util.Map;
import java.util.List;

class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        Map<String, Integer> visited = new HashMap<>();
        int maxLength = 0;

        for (int right = 1; right < nums.length; right++) {
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                String key = left + "," + diff;

                if (visited.containsKey(key)) {
                    visited.put(right + "," + diff, visited.get(key) + 1);
                } else {
                    visited.put(right + "," + diff, 2);
                }

                maxLength = Math.max(maxLength, visited.get(right + "," + diff));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestArithSeqLength solution = new LongestArithSeqLength();
        int[] nums = {3,6,9,12};

        int result = solution.longestArithSeqLength(nums);
        System.out.println("The length of the longest arithmetic subsequence is: " + result);
    }
}
