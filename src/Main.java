import ArraysAndStrings.OneWay;
import ArraysAndStrings.PalindromePermutation;
import ArraysAndStrings.RotateMatrix;
import ArraysAndStrings.URLify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var test = new RotateMatrix();
        int[][] matrix1 = {{1,2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] matrix2 = {{1}};
        int[][] matrix3 = {{1, 2}, {4, 3}};
        int[][] matrix4 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10,9,8,7}};
        int[][] matrix5 = {{1,2,3,4,5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};
        int[][] matrix6 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<int[][]> list = new ArrayList<>();
        list.add(matrix1);
        list.add(matrix2);
        list.add(matrix3);
        list.add(matrix4);
        list.add(matrix5);
        list.add(matrix6);
        for(int i = 0; i < list.size(); i++){
            int[][] matrix = list.get(i);
            test.rotateMatrix(matrix);
            for(int row = 0; row < matrix.length; row++) {
                for(int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}