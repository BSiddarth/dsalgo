package BackTracking;

import java.util.*;

public class PermuteWithBackTracking {

    public static void main(String[] args) {

        String input = "cdeeee";
        List<String> list = new ArrayList<>();

        permute(input.toCharArray(),0,list);
        System.out.println(list.size());
        System.out.println(list);
    }

       public static void permute(char [] input, int index, List<String> list) {

            if (index == input.length-1) {
//                if(!list.contains(new String(input))) { // duplicate
                    list.add(new String(input));
//                }
                return;
            }

            for (int i = index; i <=input.length-1; i++) {
                swap(i,index,input);
                permute(input,index+1,list);
                swap(i,index,input);

            }

       }

       public static void swap(int i, int j, char []input) {
         char temp = input[i];
         input[i] = input[j];
         input[j] = temp;
       }


}
