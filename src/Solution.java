import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

   /*     Example 1:

        Input: ratings = [1,0,2]
        Output: 5
        Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
        Example 2:

        Input: ratings = [1,2,2]
        Output: 4
        Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
        The third child gets 1 candy because it satisfies the above two conditions.*/

        int [] array =  {1,2,2};

        int [] candies = new int[array.length];

        Arrays.fill(candies, 1);

      int size = array.length;
      int count = 0;

        for (int i = 0; i < size; i++) {
            if (i>0&& array[i] >array[i-1]) {
                candies[i] = candies[i-1] + 1;
            } if (i<size-1&& array[i] >array[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
              count=count+candies[i];

        }


        System.out.println(count);


    }
}
