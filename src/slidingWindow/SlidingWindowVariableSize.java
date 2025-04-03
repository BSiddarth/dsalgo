package slidingWindow;
import java.util.HashMap;

class SlidingWindowVariableSize {

    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0; // Variable to store the cumulative sum of elements up to the current index
        int longestSubarray = 0; // Variable to store the maximum length of subarray with sum equal to k
        HashMap<Integer, Integer> indices = new HashMap<>(); // Map to store the first occurrence of each prefix sum

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Add the current element to the cumulative sum (prefix sum)

            // Check if the current cumulative sum is equal to the target sum (k)
            // If so, the subarray from the start to the current index has a sum equal to k
            if (prefixSum == k) {
                longestSubarray = i + 1; // Update the longest subarray length
            }

            // Check if there's any previous prefix sum such that
            // prefixSum - k is present in the map. This would indicate that
            // there's a subarray whose sum is k.
            if (indices.containsKey(prefixSum - k)) {
                // Calculate the length of the subarray and update the longest if it's larger
                longestSubarray = Math.max(longestSubarray, i - indices.get(prefixSum - k));
            }

            // Store the first occurrence of the current prefix sum in the map
            // We only store it if it's not already present because we want the earliest index
            // (this ensures that we get the longest subarray later)
            if (!indices.containsKey(prefixSum)) {
                indices.put(prefixSum, i);
            }
        }

        return longestSubarray; // Return the length of the longest subarray with sum equal to k
    }

    public static void main(String[] args) {
        SlidingWindowVariableSize solution = new SlidingWindowVariableSize();
        int[] nums = {1, -1, 5, -2, 3}; // Example array
        int k = 3; // Target sum
        int result = solution.maxSubArrayLen(nums, k);
        System.out.println("Maximum length of subarray that sums to " + k + ": " + result);
    }
}

/*Dry Run:
Let's do a dry run with the array nums = {1, -1, 5, -2, 3} and k = 3.

Iteration 1 (i = 0):
nums[i] = 1
prefixSum = 1
The sum is not equal to k.
No subarray with sum k exists yet.
Store the prefix sum in the map: indices = {1: 0}.

Iteration 2 (i = 1):
nums[i] = -1
prefixSum = 0 (1 + -1)
The sum is not equal to k.
No subarray with sum k exists yet.
Store the prefix sum in the map: indices = {1: 0, 0: 1}.

Iteration 3 (i = 2):
nums[i] = 5
prefixSum = 5 (0 + 5)
The sum is not equal to k.
We check if prefixSum - k = 5 - 3 = 2 exists in the map. It doesn't.
Store the prefix sum in the map: indices = {1: 0, 0: 1, 5: 2}.

Iteration 4 (i = 3):
nums[i] = -2
prefixSum = 3 (5 + -2)
The sum is equal to k. This means that the subarray from the start (i = 0) to the current element (i = 3) has a sum of 3.
We update longestSubarray = 4 (since it's a subarray of length 4).
Store the prefix sum in the map: indices = {1: 0, 0: 1, 5: 2, 3: 3}.

Iteration 5 (i = 4):
nums[i] = 3
prefixSum = 6 (3 + 3)

The sum is not equal to k.

We check if prefixSum - k = 6 - 3 = 3 exists in the map. It does at index 3.

We calculate the subarray length from index 4 to 3: 4 - 3 = 1. This subarray has a sum of k, but it's shorter than the previously found subarray of length 4, so longestSubarray remains 4.

Final Result:
The longest subarray with a sum of 3 is of length 4. This is the subarray from index 0 to index 3: {1, -1, 5, -2}.

Key Points:
Prefix Sum: We keep a running sum of all elements as we move through the array.

HashMap Usage: We use a HashMap to store the first occurrence of each prefix sum so that we can quickly check if a subarray with sum k exists.

Time Complexity: The solution runs in O(n) time where n is the length of the array, as we iterate through the array once and do constant-time lookups in the HashMap.

Let me know if you need further clarification!*/


