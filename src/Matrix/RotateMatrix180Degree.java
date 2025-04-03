package Matrix;

import java.util.Arrays;

public class RotateMatrix180Degree {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
              };

        int N = matrix.length;
        for (int[] ints : matrix) {
            swap(ints);
        }

        for (int j = 0; j < N; j++) {
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
                start++;
                end--;
            }

        }


        System.out.println("Rotated Matrix by 180 degrees:");
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void swap(int[] arr) {
        int star = 0;
        int end = arr.length - 1;
        while (star < end) {
            int temp = arr[star];
            arr[star] = arr[end];
            arr[end] = temp;
            star++;
            end--;
        }
    }
}
