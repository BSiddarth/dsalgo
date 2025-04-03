import java.util.Arrays;

public class Test {

        public static int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];

            Arrays.fill(answer, 1);
            int prefixsum=1;
            for(int i=0; i<n; i++) {
                answer[i]*=prefixsum;
                prefixsum*=nums[i];
            }
            int suffixSum=1;

            for(int i=n-1; i>=0; i--) {
                answer[i]*=suffixSum;
                suffixSum*=nums[i];
            }

            return answer;
        }

        public static void main(String[] args) {
            int[] nums = {1,2,3,4};
            int[] result = productExceptSelf(nums);

            // Print the result
            for (int num : result) {
                System.out.print(num + " ");
            }


}}
