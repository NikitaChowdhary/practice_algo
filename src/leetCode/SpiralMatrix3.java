package leetCode;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class SpiralMatrix3 {

    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R*C][2];
        if (R*C == 0) return result;

        int seen = 0;

        int maxCellToVisit = 1;
        int startRow = r0;
        int startCol = c0;
        if (addToResult(R, C, result, seen, startRow, startCol)) seen++;

        while(seen < R*C) {
            for (int i = 0; i<maxCellToVisit; i++) {
                if (addToResult(R, C, result, seen, startRow, ++startCol)) seen++;
            }
            for (int i = 0; i<maxCellToVisit; i++) {
                if (addToResult(R, C, result, seen, ++startRow, startCol)) seen++;
            }
            maxCellToVisit++;

            for (int i = 0; i < maxCellToVisit; i++) {
                if (addToResult(R, C, result, seen, startRow, --startCol)) seen++;
            }

            for (int i = 0; i < maxCellToVisit; i++) {
                if (addToResult(R, C, result, seen, --startRow, startCol)) seen++;
            }
            maxCellToVisit++;
        }
        return result;
    }

    private static boolean addToResult(int R, int C, int[][] result, int pos, int startRow, int startCol) {
//        pos++;
        if (startRow >=0 && startRow < R && startCol>=0 && startCol < C && pos < R*C) {
            result[pos][0] = startRow;
            result[pos][1] = startCol;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] res = spiralMatrixIII(5, 6, 1, 4);

        for (int i = 0; i< res.length; i++) {
            System.out.print("[ " + res[i][0] + ", " + res[i][1] + " ];");
        }
    }
}
