package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 */
public class SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return result;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowStart = 0, rowEnd = rows - 1;
        int colStart = 0, colEnd = cols - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) result.add(matrix[rowStart][i]);
            for (int i = rowStart + 1; i <= rowEnd; i++) result.add(matrix[i][colEnd]);

            if (rowStart < rowEnd && colStart < colEnd) {
                for (int i = colEnd - 1; i >= colStart; i--) result.add(matrix[rowEnd][i]);
                for (int i = rowEnd - 1; i >= rowStart + 1; i--) result.add(matrix[i][colStart]);
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return result;
    }
}
