import java.util.Arrays;

public class OneTwoZero {
    public static void main(String[] args) {
        int[] array = {0,2,1,1,0,0,2,1,2};
        int end = array.length - 1;
        int j = 0;
        int i = 0;

        while (i <= end) {
            if (array[i] == 0) {
                swap(i, j, array);
                j++;
                i++;
            } else if (array[i] == 2) {
                swap(i, end, array);
                end--;
                // Don't increment i here because we need to recheck the new array[i]
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
