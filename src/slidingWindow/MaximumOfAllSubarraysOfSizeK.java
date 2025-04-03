package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

    public static void main(String[] args) {
        // Sample input array
        int[] array = {6, 7, 8, 9, 11, 1, 2, 3, 5};

        // Window size
        int k = 3;

        // Initialize pointers for the sliding window
        int j = 0; // End of the window
        int i = 0; // Start of the window

        // Deque to store the actual values in the current window
        Deque<Integer> deque = new LinkedList<>();

        // End represents the length of the array
        int end = array.length;

        // Iterate through the array using the sliding window
        while (j < end) {
            // Remove all elements smaller than the current element from the deque
            // because they cannot be the maximum for the current window or future windows
            while (!deque.isEmpty() && deque.peekLast() < array[j]) {
                deque.pollLast();
            }

            // Add the current element's value to the deque
            deque.offerLast(array[j]);

            // If the window size is smaller than 'k', just move the window end forward
            if (j - i + 1 < k) {
                j++; // Expand the window by moving the right pointer
            }
            // When the window size reaches 'k'
            else if (j - i + 1 == k) {
                // The element at the front of the deque is the maximum element for the current window
                System.out.println("Maximum in window [" + i + ", " + j + "] is: " + deque.peekFirst());

                // Slide the window forward
                // If the element going out of the window is the maximum and is sliding out, remove it
                if (deque.peekFirst() == array[i]) {
                    deque.pollFirst();
                }

                // Move the start of the window forward
                i++;
                // Move the end of the window forward
                j++;
            }
        }
    }}
