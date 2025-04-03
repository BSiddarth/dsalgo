import java.util.Arrays;

public class MaximumFrequencySliodingWindow {


        public static int maxFrequency(int[] A, int k) {
            // Sort the array A
            Arrays.sort(A);

            // Initialize variables
            int i = 0, j = 0, sum = 0;
            int N = A.length; // N is the length of the array

            // Loop through the array with j as the right pointer
            for (; j < N; ++j) {
                sum += A[j]; // Add A[j] to sum

                // Check if the window size multiplied by A[j] minus the sum exceeds k
                if ((j - i + 1) * A[j] - sum > k) {
                    // If true, adjust the window by moving the left pointer i and subtract A[i] from sum
                    sum -= A[(int)i++];
                }
            }

            // Return the size of the window (j - i)
            return (int)(j - i);
        }

        // Main method to run the solution
        public static void main(String[] args) {

            // Example input array
            int[] A = {1,3,6,5,7,8, 2, 4};
            int k = 6;

            // Call the maxFrequency method and print the result
            int result = maxFrequency(A, k);
            System.out.println("The maximum frequency of the most frequent element is: " + result);
        }
    }

/*

Dry Run of maxFrequency Method
Let's go through a dry run with the example input: A = {1, 3, 6, 5, 7, 8, 2, 4} and k = 6.

Step 1: Sort A.
Sorted array A becomes {1, 2, 3, 4, 5, 6, 7, 8}.

Initialize Variables:
i = 0 (left pointer), j = 0 (right pointer), sum = 0.

Loop Iterations:

Iteration 1 (j = 0):

Add A[0] = 1 to sum.
sum = 1.
Window: {1}.
Window size = 1 (j - i + 1).
No need to adjust the window, as (j - i + 1) * A[j] - sum = 1 * 1 - 1 = 0 ≤ k.
Move to the next element.
Iteration 2 (j = 1):

Add A[1] = 2 to sum.
sum = 3.
Window: {1, 2}.
Window size = 2.
No need to adjust the window, as (j - i + 1) * A[j] - sum = 2 * 2 - 3 = 1 ≤ k.
Move to the next element.
Iteration 3 (j = 2):

Add A[2] = 3 to sum.
sum = 6.
Window: {1, 2, 3}.
Window size = 3.
No need to adjust the window, as (j - i + 1) * A[j] - sum = 3 * 3 - 6 = 3 ≤ k.
Move to the next element.
Iteration 4 (j = 3):

Add A[3] = 4 to sum.
sum = 10.
Window: {1, 2, 3, 4}.
Window size = 4.
Check: (j - i + 1) * A[j] - sum = 4 * 4 - 10 = 6 ≤ k, so no adjustment needed.
Iteration 5 (j = 4):

Add A[4] = 5 to sum.
sum = 15.
Window: {1, 2, 3, 4, 5}.
Window size = 5.
Check: (j - i + 1) * A[j] - sum = 5 * 5 - 15 = 10 > k, so we adjust the window by incrementing i.
New window: {2, 3, 4, 5}.
Update sum = 14.
Iteration 6 (j = 5):

Add A[5] = 6 to sum.
sum = 20.
Window: {2, 3, 4, 5, 6}.
Window size = 5.
Check: (j - i + 1) * A[j] - sum = 5 * 6 - 20 = 10 > k, adjust by moving i.
New window: {3, 4, 5, 6}, update sum = 18.
Iteration 7 (j = 6):

Add A[6] = 7 to sum.
sum = 25.
Window: {3, 4, 5, 6, 7}.
Window size = 5.
Check: (j - i + 1) * A[j] - sum = 5 * 7 - 25 = 10 > k, adjust by moving i.
New window: {4, 5, 6, 7}, update sum = 22.
Iteration 8 (j = 7):

Add A[7] = 8 to sum.
sum = 30.
Window: {4, 5, 6, 7, 8}.
Window size = 5.
Check: (j - i + 1) * A[j] - sum = 5 * 8 - 30 = 10 > k, adjust by moving i.
New window: {5, 6, 7, 8}, update sum = 26.
Result:
The largest window size without exceeding k is 4.

*/
