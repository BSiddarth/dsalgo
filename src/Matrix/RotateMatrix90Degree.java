package Matrix;

import java.util.Arrays;

public class RotateMatrix90Degree {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // Step 1: Transpose the matrix by swapping elements across the diagonal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                swap(matrix, i, j);
            }
        }
        // Step 2: Reverse each row of the transposed matrix to complete the 90-degree rotation
        for (int[] row : matrix) {
            reverseRow(row);
        }
        // Print the rotated matrix
        System.out.println("Rotated Matrix:");
        System.out.println(Arrays.deepToString(matrix));
    }
    // Function to swap elements at (i, j) and (j, i) in the matrix
    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    // Function to reverse elements in a row for the 90-degree rotation
    private static void reverseRow(int[] row) {
        int start = 0, end = row.length - 1;
        while (start < end) {
            swapRow(row, start, end);
            start++;
            end--;
        }
    }

    // Helper function to swap two elements within a row
    private static void swapRow(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}

/*

Certainly, let's go through each part of the code in even more detail to clarify how it rotates the matrix 90 degrees clockwise. We’ll use the example matrix:

csharp
Copy code
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
This will be transformed by first transposing it and then reversing each row.

Step 1: Transpose the Matrix
Goal of Transpose: Swap elements across the main diagonal so that matrix[i][j] becomes matrix[j][i]. This converts rows into columns.

The matrix has dimensions 3x3, so we loop through each i and j where j <= i to perform the swaps.

Transpose Iterations
i = 0

j = 0: Swap matrix[0][0] with matrix[0][0] (no change)
Result: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
i = 1

j = 0: Swap matrix[1][0] with matrix[0][1]

Before swap: matrix[1][0] = 4, matrix[0][1] = 2
After swap: matrix[1][0] becomes 2, matrix[0][1] becomes 4
Intermediate Result: [[1, 4, 3], [2, 5, 6], [7, 8, 9]]

j = 1: Swap matrix[1][1] with matrix[1][1] (no change)

Result: [[1, 4, 3], [2, 5, 6], [7, 8, 9]]

i = 2

j = 0: Swap matrix[2][0] with matrix[0][2]

Before swap: matrix[2][0] = 7, matrix[0][2] = 3
After swap: matrix[2][0] becomes 3, matrix[0][2] becomes 7
Intermediate Result: [[1, 4, 7], [2, 5, 6], [3, 8, 9]]

j = 1: Swap matrix[2][1] with matrix[1][2]

Before swap: matrix[2][1] = 8, matrix[1][2] = 6
After swap: matrix[2][1] becomes 6, matrix[1][2] becomes 8
Intermediate Result: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]

j = 2: Swap matrix[2][2] with matrix[2][2] (no change)

Result: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]

Transposed Matrix:

1 4 7
2 5 8
3 6 9
Step 2: Reverse Each Row
Goal of Row Reversal: Reversing each row transforms the matrix into a 90-degree clockwise rotation.

Row Reversals
Row 0: [1, 4, 7]

Swap matrix[0][0] with matrix[0][2]
Before swap: matrix[0][0] = 1, matrix[0][2] = 7
After swap: matrix[0][0] becomes 7, matrix[0][2] becomes 1
Result: [[7, 4, 1], [2, 5, 8], [3, 6, 9]]
Row 1: [2, 5, 8]

Swap matrix[1][0] with matrix[1][2]
Before swap: matrix[1][0] = 2, matrix[1][2] = 8
After swap: matrix[1][0] becomes 8, matrix[1][2] becomes 2
Result: [[7, 4, 1], [8, 5, 2], [3, 6, 9]]
Row 2: [3, 6, 9]

Swap matrix[2][0] with matrix[2][2]
Before swap: matrix[2][0] = 3, matrix[2][2] = 9
After swap: matrix[2][0] becomes 9, matrix[2][2] becomes 3
Final Result: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
Final Rotated Matrix
The matrix after a 90-degree clockwise rotation:

7 4 1
8 5 2
9 6 3
Explanation Recap
Transpose: This step rearranges the rows and columns.
Row Reversal: Each row is reversed to complete the clockwise rotation.
Output
The final printed matrix is:

lua
Rotated Matrix:
[[7, 4, 1], [8, 5, 2], [9, 6, 3]]
*/

