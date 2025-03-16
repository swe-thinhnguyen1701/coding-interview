package ArraysAndStrings;

/**
 * Problem description:
 * Write an algorithm such that if an element in an M x N matrix is 0, its entire row and column are set to 0.
 *
 * ANALYSIS:
 * CASE 1:
 * Suppose that I am allowed to use extra space.
 * I will create an array to keep track where a 0 appear in the matrix.
 * Iterate through the matrix starting from [0][0] to [m - 1][n - 1]. Whenever I encounter a 0, I will mark it T in the
 * array that I created before.
 * Now, I will rebuild the matrix based on the marker from the array I marked before. Whenever, it's true, I will turn
 * its row and col to 0.
 *
 * Time Complexity:
 * The first iteration takes O(m x n) to locate 0.
 * The second iteration also takes O(m x n) to rebuild.
 * update row and col will take extra m and n, where m is number of rows and n is the number of columns.
 *
 * Space Complexity:
 * Since I use extra memory to locate the 0, it takes O(m + n) spaces.
 *
 * CASE 2:
 * Suppose that I am NOT allowed to use extra space.
 * Let try with a matrix 3x3
 * [0, 1, 1]
 * [1, 1, 1]
 * [1, 1, 1]
 *
 * starting at [0][0]. Because its value is 0, I need to update its row and col.
 * [0, 0, 0]
 * [0, 1, 1]
 * [0, 1, 1]
 *
 * However, when I move to the next col[0][1], it will also update its row and col. This is bad approach.
 * I should not update the matrix when encountering a 0, but I need to something to keep track
 *
 */

public class ZeroMatrix {

    // CASE 1
    public void buildZeroMatrix(int[][] matrix) {
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroCol = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for(int i = 0; i < zeroRow.length; i++){
            if(zeroRow[i]){
                updateRow(matrix, i);
            }
        }

        for(int i = 0; i < zeroCol.length; i++){
            if(zeroCol[i]){
                updateCol(matrix, i);
            }
        }
    }

    public void buildZeroMatrix2(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowHasZero = true;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColHasZero = true;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                updateRow(matrix, i);
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                updateCol(matrix, i);
            }
        }

        if(firstRowHasZero){
            updateRow(matrix, 0);
        }
        if(firstColHasZero){
            updateCol(matrix, 0);
        }
    }

    private void updateRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix[row].length; i++)
            matrix[row][i] = 0;
    }

    private void updateCol(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++)
            matrix[i][col] = 0;
    }
}
