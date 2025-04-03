package hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{100,200,4,2,3,1}));
    }
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count = 0;

        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i]-1)) {

                count++;
            }else {
                count=1;
            }
        }

        return max;
    }
}
