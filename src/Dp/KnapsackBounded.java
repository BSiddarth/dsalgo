package Dp;

import java.util.HashMap;

public class KnapsackBounded {
    public static void main(String[] args) {
       int [] Weights = {1, 2, 3};
       int [] Values ={6, 10, 12};
       int maxCapacity = 5;

       /*
       */

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < Weights.length; i++) {
         map.put(Weights[i], Values[i]);
        }

        System.out.println(map);
        int Max=0;
        for (int i = 0; i < map.size(); i++) {
            int diff = maxCapacity - Weights[i];
            if (map.containsKey(diff)) {
                Max = Math.max(Max, map.get(diff)+map.get(Weights[i]));
            }

        }
        System.out.println(Max);

    }
}
