package slidingWindow;

import java.util.LinkedList;
import java.util.Queue;


public class FirstNegativeNumberInEveryWindow {

    public static void main(String[] args) {
        // Sample input array with both negative and positive numbers
        int[] array = {12, -1, -7, 8, 15, 30, 16, 28};

        // Window size
        int k = 3;

        // Initialize pointers for the sliding window
        int j = 0; // End of the window
        int i = 0; // Start of the window

        // Queue to store negative values in the current window
        Queue<Integer> negativeQueue = new LinkedList<>();

        // End represents the length of the array
        int end = array.length;

        // Iterate through the array using the sliding window
        while (j < end) {
            // If the current element is negative, add the actual value to the queue
            if (array[j] < 0) {
                negativeQueue.offer(array[j]);
            }

            // If the window size is smaller than 'k', just move the window end forward
            if (j - i + 1 < k) {
                j++; // Expand the window by moving the right pointer
            }
            // When the window size reaches 'k'
            else if (j - i + 1 == k) {
                // Check for the first negative number in the current window
                if (!negativeQueue.isEmpty()) {
                    // Print the first negative number in the current window
                    System.out.println("First negative number in window [" + i + ", " + j + "] is: " + negativeQueue.peek());
                } else {
                    // If no negative number is present in the current window
                    System.out.println("No negative number in window [" + i + ", " + j + "]");
                }

                // Slide the window forward
                // If the element going out of the window is negative, remove it from the queue
                if (!negativeQueue.isEmpty() && array[i] == negativeQueue.peek()) {
                    negativeQueue.poll(); // Remove the first element if it matches the one sliding out
                }

                // Move the start of the window forward
                i++;
                // Move the end of the window forward
                j++;
            }
        }
    }
}


