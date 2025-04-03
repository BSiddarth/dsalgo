package Matrix;

import java.util.Arrays;

public class SetMatrixZerosWithoutSpace {
    public static void main(String[] args) {
        /*
        [   1          1         1 ]
       [  1         0        1 ]
      [ 1        1       1 ]
    */

        int[][] array = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int rows = array.length;
        int cols = array[0].length;
        boolean iscols = false;


        for (int i = 0; i < rows; i++) {
            if (array[i][0] == 0) {
                iscols = true;
                break;
            }
            for (int j = 1; j < cols; j++) {
                if (array[i][j] == 0) {
                    array[i][0] = 0;
                    array[0][j] = 0;
                }
            }

        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (array[i][0] == 0||array[0][j] == 0) {
                    array[i][j] = 0;
                }
            }
        }

        if(array[0][0]==0){
            for(int j=0;j<cols;j++){
                array[0][j]=0;
            }
        }

        if (iscols) {
            for (int i = 0; i < rows; i++) {
                array[i][0] = 0;
            }
        }


        System.out.println(Arrays.deepToString(array));


    }


}
