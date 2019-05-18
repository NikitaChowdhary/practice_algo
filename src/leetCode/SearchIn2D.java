package leetCode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * https://leetcode.com/problems/search-a-2d-matrix
 *
 * Time Complexity - O(n)
 * Space - O(1)
 *
 */
public class SearchIn2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int R = matrix.length;
        int row = 0, col = matrix[0].length - 1;

        while(row < R && col >=0) {
            if (target > matrix[row][col])
                row++;
            else if (target < matrix[row][col])
                col--;
            else return true;
        }
        return false;

    }
}
