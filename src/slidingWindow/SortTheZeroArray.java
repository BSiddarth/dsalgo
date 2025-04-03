package slidingWindow;

import java.util.Arrays;

public class SortTheZeroArray
{
    public static void main(String[] args) {

        int[] array = {10,45,78,0,9,0,67,};

        int j=0;

        for (int i = 0; i < array.length; i++){
            if (array[i] > 0){
                swap(i,j,array);
                j++;
            }
        }
        System.out.println(Arrays.toString(array));

    }
    private static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
