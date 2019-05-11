package leetCode;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        if (n == 0) return result;

        int[] diffRow = {0, 1, 0, -1};
        int[] diffCol = {1, 0, -1, 0};
        int row = 0, col = 0, diffIndex = 0;
        for (int i = 1; i<=n*n; i++) {
            result[row][col] = i;
            seen[row][col] = true;

            int nextRow = row + diffRow[diffIndex];
            int nextCol = col + diffCol[diffIndex];
            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !seen[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                diffIndex = (diffIndex + 1)%4;
                row += diffRow[diffIndex];
                col += diffCol[diffIndex];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
       int[][] res = generateMatrix(n);

       for (int i = 0; i< n; i++) {
           for (int j = 0; j<n; j++)
               System.out.print(res[i][j] + " ");
           System.out.println();
       }
    }
}
