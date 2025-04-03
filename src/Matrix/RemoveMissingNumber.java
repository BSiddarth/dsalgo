package Matrix;

import java.util.Arrays;

public class RemoveMissingNumber {
    public static void main(String[] args) {
        RemoveMissingNumber removeMissingNumber = new RemoveMissingNumber();

        int [] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(removeMissingNumber.missingNumber(nums));


    }

        public int missingNumber(int[] nums) {
            int missing = nums.length;
            for (int i = 0; i < nums.length; i++) {
                missing ^= i ^ nums[i];
            }
            return missing;
        }

}
