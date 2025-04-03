package BinarySearchApplication;

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray findMinimuminRotatedSortedArray = new FindMinimuminRotatedSortedArray();
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(findMinimuminRotatedSortedArray.findMin(nums));


    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // the smallest value must be in the right part of the array
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest value is in the left part (including mid)
                right = mid;
            }
        }

        // When left == right, we have found the smallest element
        return nums[left];
    }
}
