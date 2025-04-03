package Dp;


import java.util.Arrays;

public class RightAndLeftEqualFRomCurrentPosition {

    public static void main(String[] args) {

        int [] array = {1, 2, 3, 4, 5, 6, 7, 8}; // o/p 5  value 6
        int [] leftMaxArray = new int[array.length];
        int [] rightMaxArray = new int[array.length];

        leftMaxArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            leftMaxArray[i] = leftMaxArray[i - 1] + array[i];
        }
        rightMaxArray[array.length-1] = array[array.length-1];

        for (int i =array.length-2 ; i >=0; i--) {
            rightMaxArray[i] = rightMaxArray[i+1] + array[i];
        }

     for (int i = 1; i < array.length; i++) {
         if (leftMaxArray[i] == rightMaxArray[i]) {
             System.out.println(i);
             System.out.println(leftMaxArray[i]);
         }
     }

    }
}
