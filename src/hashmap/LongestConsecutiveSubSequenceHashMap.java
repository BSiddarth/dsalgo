package hashmap;

import java.util.HashSet;

public class LongestConsecutiveSubSequenceHashMap {
    public static void main(String[] args) {

        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        HashSet<Integer> hashSet = new HashSet<>();
        for (int j : nums1) hashSet.add(j);
        int rest = 1;
        for (int num : nums1) {
            if (!hashSet.contains(num - 1)) {
                int current = 1;
                while (hashSet.contains(num + current)) {
                    current++;
                }
                rest = Math.max(rest, current);
            }
        }
        System.out.println(rest);
    }
}
