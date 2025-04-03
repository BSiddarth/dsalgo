package slidingWindow;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        // Sample input array
        int[] array = {6, 7, 8, 9, 11, 1, 2, 3, 5};

        // Window size
        int k = 4;

        // Initialize pointers for the sliding window
        int j = 0; // End of the window
        int i = 0; // Start of the window

        // End represents the length of the array
        int end = array.length;

        // Initialize sum and max
        int sum = 0;
        int max = Integer.MIN_VALUE; // Set to the smallest possible value initially

        // Sliding window loop
        while (j < end) {
            // Add the current element to the window sum
            sum += array[j];

            // If the window size is smaller than 'k', just move the window end forward
            if (j - i + 1 < k) {
                j++; // Expand the window by moving the right pointer
            }
            // When the window size reaches 'k'
            else if (j - i + 1 == k) {
                // Update the maximum sum encountered so far
                max = Math.max(max, sum);

                // Slide the window forward by removing the first element from the sum
                sum -= array[i];

                // Move both pointers to keep the window size 'k'
                i++; // Move the start of the window forward
                j++; // Move the end of the window forward
            }
        }

        // Output the maximum sum of subarrays of size 'k'
        System.out.println("Maximum sum of subarrays of size " + k + " is: " + max);
    }
}
