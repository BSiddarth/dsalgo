package BinarySearchApplication;

import java.util.Arrays;

public class RotateArrayinKmoves {

    public static void main(String[] args) {
        int [] array ={1,2,3,4,5,6,7};

        int k=3;
        int n = array.length;
        k%=n;
        reverseArray(array,0,n-1);
        reverseArray(array,0,k-1);
        reverseArray(array,k,n-1);

        System.out.println(Arrays.toString(array));
    }

    private static void reverseArray(int[] array, int start, int end) {
      while(start < end) {
          int temp = array[start];
          array[start] = array[end];
          array[end] = temp;
          start++;
          end--;
      }

    }
}
