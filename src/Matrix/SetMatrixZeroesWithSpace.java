package Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroesWithSpace {
    public static void main(String[] args) {
        int[][] array = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        int rows = array.length;
        int cols = array[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    array[i][j] = 0;

                }
            }
        }

        System.out.println(Arrays.deepToString(array));

    }
}
