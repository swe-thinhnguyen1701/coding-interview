package ArraysAndStrings;



/**
 * Problem description:
 * Given an image represented by an N x N matrix, where each pixel in the image is represented by an integer, write a
 * method to rotate the image by 90 degree. Can you do this in place?
 *
 * EXAMPLE:
 * [1] → [1]
 *
 * [1, 2]  → [4, 1]
 * [3, 4]    [3, 2]
 *
 * [1, 2, 3]     [7, 8, 1]
 * [8, 9, 4]  →  [6, 9, 2]
 * [7, 6, 5]     [5, 4, 3]
 *
 * ANALYSIS:
 * Time Complexity:
 * The outer loop cost O(N/2)
 * The rotate method cost O(N)
 * The swap method is constant O(1)
 * Therefore, the total time complexity is O(N/2 * N) ≃ O(N²)
 *
 * Space Complexity:
 * Since I do not use extra memory while rotating, it maintains at O(1).
 *
 * My approach rotates layer by layer.
 * [1, 2, 3]     [3, 4, 1]     [5, 6, 1]     [7, 8, 1]
 * [8, 9, 4]  →  [8, 9, 2]  →  [8, 9, 2]  →  [6, 9, 2]
 * [7, 6, 5]     [7, 6, 5]     [7, 4, 3]     [5, 4, 3]
 *
 * 
 */

public class RotateMatrix {
    private int[][] matrix;

    public void rotateMatrix(int[][] matrix) {
        this.matrix = matrix;
        for(int i = 0; i < matrix.length / 2; i++){
            rotate(i);
        }
    }

    private void rotate(int startAt) {
        int maxRow = matrix.length - (2 * startAt);
        int maxCol = matrix[0].length - startAt;
        int row = startAt, col = maxCol - 1;
        int n = maxRow - 1;

        for(int i = 0; i < n; i++){
            swap(row, col, startAt, startAt + i);
            row++;
        }

        for(int i = 0; i < n; i++){
            swap(row, col, startAt, startAt + i);
            col--;
        }

        for(int i = 0; i < n; i++){
            swap(row, col, startAt, startAt + i);
            row--;
        }
    }

    private void swap(int row1, int col1, int row2, int col2) {
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] =tmp;
    }
}
