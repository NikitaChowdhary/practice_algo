package leetCode;

/**
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLIfe {

    static int rows, cols;
    public static void gameOfLife(int[][] board) {
        if (board.length == 0) return;

        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = liveNeighbours(i, j, board);
                if (board[i][j] == 0 && count == 3) board[i][j] = -3;
                else if (board[i][j] > 0 && count > 0) board[i][j] = count;
            }
        }

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.abs(board[i][j]) == 3 || board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] > 3 || board[i][j] < 2) board[i][j] = 0;
            }
        }
    }

    private static int liveNeighbours(int i, int j, int[][] board) {
        int count = 0;
        if (i - 1 >= 0) {
            if (board[i-1][j] > 0) count++;
            if (j + 1 < cols && board[i - 1][j + 1] > 0) count++;
            if (j - 1 >= 0 && board[i - 1][j - 1] > 0) count++;
        }
        if (i + 1 < rows) {
            if (board[i+1][j] > 0) count++;
            if (j + 1 < cols && board[i + 1][j + 1] > 0) count++;
            if (j - 1 >= 0 && board[i + 1][j - 1] > 0) count++;
        }
        if (j + 1 < cols && board[i][j + 1] > 0) count++;
        if (j - 1 >= 0 && board[i][j - 1] > 0) count++;
        return count;
    }


    public static void main(String[] args) {
        int[][] board = {{1,0,0,0,0,1},{0,0,0,1,1,0},{1,0,1,0,1,0},{1,0,0,0,1,0},{1,1,1,1,0,1},{0,1,1,0,1,0},{1,0,1,0,1,1},{1,0,0,1,1,1},{1,1,0,0,0,0}};
        gameOfLife(board);
        System.out.println("done");
    }
}
