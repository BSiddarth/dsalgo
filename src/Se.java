public class Se {
    public static void main(String[] args) {

        int[] prices = {2, 3, 1, 1, 4};

        if (canReachLastIndex(prices))
            System.out.println("yes");
        else
            System.out.println("no");

    }

    public static boolean canReachLastIndex(int[] prices) {
        int lastReachable = prices.length - 1;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (i + prices[i] >= lastReachable) {
                lastReachable = i;
            }
        }
        return lastReachable == 0;
    }

}

/*

Understanding and Dry Run of the Code
The given code checks whether you can jump from the first index of the prices array to the last index.
It uses a greedy approach, traversing the array backward and updating the last index that can be reached.
Let's dry run the code with the input {2, 3, 1, 1, 4}.

Dry Run Step by Step
Given array: prices = {2, 3, 1, 1, 4}

Initialization: last = prices.length - 1 = 4
Iterate from right to left:

i = 4:
i + prices[i] = 4 + 4 = 8 (greater than last = 4)
Update last = 4
i = 3:
i + prices[i] = 3 + 1 = 4 (equal to last = 4)
Update last = 3
i = 2:
i + prices[i] = 2 + 1 = 3 (equal to last = 3)
Update last = 2
i = 1:
i + prices[i] = 1 + 3 = 4 (greater than last = 2)
Update last = 1
i = 0:
i + prices[i] = 0 + 2 = 2 (greater than last = 1)
Update last = 0
Final Check: last == 0 is true, so the function returns true, and the output is "yes".

Explanation
The algorithm works by checking if you can reach the last index from the current position, moving backward.
If you can reach or pass the last index from the current index, update last to the current index.
Finally, if you can reduce last to 0, you can jump from the start to the end.*/
