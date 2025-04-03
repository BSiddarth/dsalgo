import java.util.Arrays;
import java.util.PriorityQueue;




public class FinalArrayStateAfterKMultiplicationOperations {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        FinalArrayStateAfterKMultiplicationOperations solution = new FinalArrayStateAfterKMultiplicationOperations();
        System.out.println(Arrays.toString(solution.getFinalState(nums, k, multiplier)));
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums; // No change if multiplier is 1
        }

        // Min-heap to always fetch the smallest value efficiently
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        // Populate the priority queue with initial values
        for (int i = 0; i < nums.length; ++i) {
            minHeap.offer(new long[]{nums[i], i});
        }

        // Apply multiplications up to k times on the smallest elements
        while (k > 0) {
            long[] current = minHeap.poll();
            current[0] *= multiplier;
            minHeap.offer(current);
            k--;
        }

        // Construct the final state of the array by placing elements at their original positions
        int[] result = new int[nums.length];
        while (!minHeap.isEmpty()) {
            long[] current = minHeap.poll();
            result[(int) current[1]] = (int) (current[0] % ((int) 1e9 + 7));
        }

        return result;
    }
}
