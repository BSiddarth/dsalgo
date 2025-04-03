package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>(); // List to store elements in spiral order
        int rowBegin = 0; // Start row boundary
        int rowEnd = matrix.length - 1; // End row boundary
        int colBegin = 0; // Start column boundary
        int colEnd = matrix[0].length - 1; // End column boundary

        // Traverse the matrix in a spiral order until all boundaries are covered
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse right across the top row
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++; // Move top boundary down

            // Traverse down the last column
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--; // Move right boundary left

            // Traverse left across the bottom row if still within bounds
            if (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--; // Move bottom boundary up

            // Traverse up the first column if still within bounds
            if (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++; // Move left boundary right
        }

        return list;
    }
}

/*
Dry Run with matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
Initialization:

rowBegin = 0, rowEnd = 2, colBegin = 0, colEnd = 2
First Iteration:

Traverse Right along the top row (rowBegin = 0):

Add matrix[0][0] = 1, matrix[0][1] = 2, matrix[0][2] = 3
list = [1, 2, 3]
Increment rowBegin to 1.
Traverse Down the rightmost column (colEnd = 2):

Add matrix[1][2] = 6, matrix[2][2] = 9
list = [1, 2, 3, 6, 9]
Decrement colEnd to 1.
Traverse Left along the bottom row (rowEnd = 2):

Add matrix[2][1] = 8, matrix[2][0] = 7
list = [1, 2, 3, 6, 9, 8, 7]
Decrement rowEnd to 1.
Traverse Up the leftmost column (colBegin = 0):

Add matrix[1][0] = 4
list = [1, 2, 3, 6, 9, 8, 7, 4]
Increment colBegin to 1.
Second Iteration:

Traverse Right along the new top row (rowBegin = 1):
Add matrix[1][1] = 5
list = [1, 2, 3, 6, 9, 8, 7, 4, 5]
Increment rowBegin to 2, which exceeds rowEnd.
        At this point, all boundaries are crossed, so the loop ends, and list contains [1, 2, 3, 6, 9, 8, 7, 4, 5].

This matches the expected output for the spiral order traversal.*/
