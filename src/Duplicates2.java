import java.util.Arrays;

public class Duplicates2 {
    public static void main(String[] args) {
        Duplicates2 d = new Duplicates2();
        int[] nums = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3};
        int res = d.removeDuplicates(nums);
        System.out.println(res);

    }



        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int i = 1; // Pointer to iterate through the array
            int j = 1; // Pointer to track position for valid elements
            int count = 1; // Count of occurrences of the current element

            while (i < nums.length) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                    if (count > 2) {
                        i++;
                        continue;
                    }
                } else {
                    count = 1;
                }
                nums[j] = nums[i];
                j++;
                i++;
            }

            // Java arrays can't be resized like C++ vectors,
            // so we return the size directly.
            return j;
        }
    }


