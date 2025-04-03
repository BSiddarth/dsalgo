package Matrix;

import java.util.Arrays;

public class RotateMatrix270Degree {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int N = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < N; j++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;
                start++;
                end--;
            }
        }

        System.out.println("Rotated Matrix by 270 degrees:");
        System.out.println(Arrays.deepToString(matrix));
    }
}
