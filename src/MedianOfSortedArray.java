public class MedianOfSortedArray {

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {2, 3,4,5};
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // Assign nums1 to A and nums2 to B for readability

        // Calculate the total length of combined arrays and the half point
        int total = A.length + B.length;
        int half = total / 2;

        // Ensure A is the smaller array to keep the binary search on fewer elements
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        // Set initial boundaries for binary search on array A
        int l = 0, r = A.length - 1;

        // Perform binary search on the smaller array
        while (true) {
            // Middle index in A (partition point)
            int i = (l + r) / 2;
            // Calculate corresponding index in B to make left half of both arrays equal in size
            int j = half - i - 2;

            // Values just on the left and right of the partition in A
            int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            int Aright = (i + 1 < A.length) ? A[i + 1] : Integer.MAX_VALUE;

            // Values just on the left and right of the partition in B
            int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            int Bright = (j + 1 < B.length) ? B[j + 1] : Integer.MAX_VALUE;

            // Check if the partition is valid: elements on the left are less than or equal to elements on the right
            if (Aleft <= Bright && Bleft <= Aright) {
                // If the total number of elements is odd, return the middle element
                if (total % 2 != 0) {
                    return Math.min(Aright, Bright);
                }
                // If even, return the average of the two middle elements
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            // If Aleft is greater than Bright, move left in A
            else if (Aleft > Bright) {
                r = i - 1;
            }
            // If Bleft is greater than Aright, move right in A
            else {
                l = i + 1;
            }
        }
    }
}

/*
Dry Run Example
Consider two arrays:

nums1 = [1, 3]
nums2 = [2]
Step-by-Step Execution:
Initialization:

Set A = nums1 and B = nums2 (no need to swap as A is already smaller).
        total = 3, half = total / 2 = 1.
Binary Search in A:

Start with l = 0, r = 1 (the length of A minus one).
First Iteration:

Calculate i = (l + r) / 2 = 0.
Calculate j = half - i - 2 = -1.
Define Edge Values:

Aleft = A[i] = A[0] = 1, Aright = A[i + 1] = A[1] = 3.
Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE = Integer.MIN_VALUE.
        Bright = B[j + 1] = B[0] = 2.
Partition Check:

Check if Aleft <= Bright and Bleft <= Aright, which is 1 <= 2 and -∞ <= 3 (both true).
Since the total number of elements is odd (3), return Math.min(Aright, Bright) = Math.min(3, 2) = 2.
Thus, the median of [1, 3] and [2] is 2.

Complexity Analysis and Optimization
Time Complexity: O(log(min(m, n))), where m and n are the lengths of nums1 and nums2. This is due to the binary search on the smaller array.

Space Complexity: O(1), as we only use a constant amount of space.

The optimization is in using binary search on the smaller of the two arrays, which minimizes the search space, improving efficiency.*/







