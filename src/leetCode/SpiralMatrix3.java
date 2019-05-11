package leetCode;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class SpiralMatrix3 {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        if (R*C == 0) return result;

        boolean[][] seen = new boolean[R][C];
        int[] rowDiff = {0, 1, 0, -1};
        int[] colDiff = {1, 0, -1, 0};

        int startRow = r0, startCol = c0, diffIndex = 0;
        for (int i = 0; i< R*C; i++) {
            result[i][0] = startRow;
            result[i][1] = startCol;

            seen[startRow][startCol] = true;

            int currenRow = startRow + rowDiff[diffIndex];
            int currentCol = startCol + colDiff[diffIndex];

            if (currenRow >=0 && currenRow < R && currentCol >= 0 && currentCol < C && !seen[currenRow][currentCol]) {
                diffIndex = (diffIndex + 1) % 4;
                startRow += rowDiff[diffIndex];
                startCol += colDiff[diffIndex];

            } else {
                startRow = currenRow;
                startCol = currentCol;
            }
        }
        return result;
    }
}
