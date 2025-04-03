package hashmap;

import java.util.HashMap;
import java.util.Map;

public class TargetSumWithHasMapCount {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println(countPairs(arr, target));
    }

    static int countPairs(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;

        for (int j : arr) {
            // Check if the complement (target - arr[i])
            // exists in the map. If yes, increment count
            if (freq.containsKey(target - j)) {
                System.out.println(freq.get(target - j) + " " + j);
                cnt += freq.get(target - j);
                System.out.println(cnt);
            }
            // Increment the frequency of arr[i]
            freq.put(j, freq.getOrDefault(j, 0) + 1);
        }
        return cnt;
    }


















}
