package BinarySearchApplication;

public class RotatedArraywithDuplicates {

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2, 3};
        int target = 3;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // If the target is found, return the index
            if (nums[mid] == target) {
                System.out.println(mid);
                return;
            }

            // Handle duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Left part is sorted
            else if (nums[start] <= nums[mid]) {
                // Check if the target lies in the sorted left half
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right part is sorted
            else {
                // Check if the target lies in the sorted right half
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println("Target not found");
    }
}
