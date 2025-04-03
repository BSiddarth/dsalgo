package Matrix;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        FirstMissingPositiveNumber firstMissingPositiveNumber = new FirstMissingPositiveNumber();

        int[] arr = {1,2,0};
        System.out.println(firstMissingPositiveNumber.firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace all non-positive values (<= 0)
        // This is because we only care about numbers between 1 and n.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n + 1;
        }

        // Step 2: Place each number in its "correct" position if possible.
        // Each number k should ideally be placed at index k-1.
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at its target position nums[i] - 1
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 3: Find the first position where index + 1 != value at that index.
        // This will give us the smallest missing positive integer.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions from 1 to n are filled correctly, the missing integer is n + 1.
        return n + 1;
    }
}

/*
Detailed Dry Run of Code with Example
Let’s use the input array nums = [3, 4, -1, 1].

Step 1: Replace Non-positive and Out-of-Bounds Numbers
Purpose: We set numbers that are either non-positive or greater than n to n + 1 so they don’t interfere with finding the smallest missing positive number.

Initial array: [3, 4, -1, 1]

After Step 1:

nums[2] is -1, which is less than or equal to 0, so we set it to n + 1 = 5.
Resulting array after this step: [3, 4, 5, 1]
Step 2: Rearrange Numbers to Their Correct Positions
Goal: Each number k should ideally be placed at index k-1.
Starting with the array: [3, 4, 5, 1]
Iteration 1 (i = 0):

nums[0] = 3, and since it should ideally be at index 2 (3 - 1 = 2), we swap nums[0] and nums[2].
Array after swap: [5, 4, 3, 1]
Iteration 2 (i = 0 again, due to the swap):

nums[0] = 5, which is out of range (greater than n), so we skip this element.
Iteration 3 (i = 1):

nums[1] = 4, and it should ideally be at index 3 (4 - 1 = 3), so we swap nums[1] and nums[3].
Array after swap: [5, 1, 3, 4]
Iteration 4 (i = 1 again, due to the swap):

nums[1] = 1, which should ideally be at index 0 (1 - 1 = 0), so we swap nums[1] and nums[0].
Array after swap: [1, 5, 3, 4]
Iteration 5 (i = 2):

nums[2] = 3, which is already in the correct position, so we move to the next element.
Iteration 6 (i = 3):

nums[3] = 4, which is already in the correct position, so we complete this step.
Array after Step 2: [1, 5, 3, 4]
Step 3: Find the First Missing Positive
Goal: After arranging the array, we look for the first index where nums[i] != i + 1.
Starting with the array: [1, 5, 3, 4]
Index 0: nums[0] = 1, which matches 0 + 1 = 1.
Index 1: nums[1] = 5, which does not match 1 + 1 = 2.
The first mismatch is found at index 1, so the smallest missing positive integer is 2.
Final Output: 2

Explanation Recap
Step 1 ensures that out-of-range values don’t interfere.
Step 2 arranges elements such that k is ideally at index k - 1.
Step 3 identifies the smallest missing positive by looking for the first mismatch.
Complexity Analysis
Time Complexity:
Each step runs in O(n), making the overall time complexity O(n).
Space Complexity:
Since we modify the array in place without using extra space, the space complexity is O(1).
This solution efficiently finds the smallest missing positive integer in linear time and constant space, meeting the requirements.
*/