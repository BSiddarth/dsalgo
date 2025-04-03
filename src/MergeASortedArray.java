import java.util.Arrays;

public class MergeASortedArray {

//    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//    Output: [1,2,2,3,5,6]
//    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        int r1 = m - 1;
        int r2 = n - 1;
        int k = nums.length - 1;
        while (k >= 0) {
            if (r1 >= 0 && r2 >= 0) {
                nums[k--] = nums[r1] > nums2[r2] ? nums[r1--] : nums2[r2--];
            } else if (r1 >= 0) {
                nums[k--] = nums[r1--];
            } else {
                nums[k--] = nums[r2--];
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
