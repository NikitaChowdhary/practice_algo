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


            int y = 1;
            while(y <= maxCellToVisit) {

                if (addToResult(R, C, result, seen, startRow, ++startCol))
                    seen++;
                y++;
            }

            int x = 1;
            while(x <= maxCellToVisit) {
                startRow++;
                if (addToResult(R, C, result, seen, startRow, startCol))
                    seen++;
                x++;
            }
            maxCellToVisit++;
            y = 0;
            x = 0;


            while(y < maxCellToVisit) {
                startCol--;
                if (addToResult(R, C, result, seen, startRow, startCol)) {
                    seen++;
                }
                y++;
            }

            while(x < maxCellToVisit) {
                startRow--;
                if (addToResult(R, C, result, seen, startRow, startCol)) {
                    seen++;
                }

                x++;
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
