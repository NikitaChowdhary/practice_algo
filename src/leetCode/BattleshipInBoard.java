package leetCode;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 */

public class BattleshipInBoard {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X'){
                    count++;
                    replace(board, i, j);
                }
            }
        }
        return count;
    }

    private void replace(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[i].length;
        while(true) {
            board[i][j] = '.';
            if (i + 1 < rows && board[i + 1][j] == 'X') i++;
            else if (j + 1 < cols && board[i][j+1] == 'X') j++;
            else break;
        }
    }
}
