package hashmap;

import java.util.Arrays;

public class TargetSumPairsCount {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1};
        int target = 2;

        /*

        1   1   1         1 pair
        0   1   2

        1    1    1       2 pair
        0    3    4

        1    1    1       3 pair
        0    4    5

        1    1     1      4 pair
        1    2     3

        1    1      1

         */

        int res = 0;
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {


            if (arr[start] + arr[end] < target) {
                start++;
            } else if (arr[start] + arr[end] > target) {
                end--;
            } else {

                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[start], ele2 = arr[end];

                while (start <= end && arr[start] == ele1) {
                    start++;
                    cnt1++;
                }
                while (start <= end && arr[end] == ele2) {
                    end--;
                    cnt2++;

                }

                if (ele1 == ele2) {
                    res += (cnt1) * (cnt1 - 1) / 2;
                } else {
                    res += (cnt1 * cnt2);
                }


            }


        }
        System.out.println(res);


    }
}
