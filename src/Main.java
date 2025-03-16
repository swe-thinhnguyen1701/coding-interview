import ArraysAndStrings.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var test = new ZeroMatrix();
       int[][] matrix = {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}};
       test.buildZeroMatrix(matrix);
       for(int i = 0; i < matrix.length; i++){
           for(int j = 0; j < matrix[0].length; j++){
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
    }
}