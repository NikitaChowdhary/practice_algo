package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    int rows, cols;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] seen = new boolean[rows][cols];

        int count = 0;


        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!seen[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, seen);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] seen) {
        seen[i][j] = true;

        for (Position adj : getAdjacent(i, j)) {
            if (!seen[adj.x][adj.y] && grid[adj.x][adj.y] == '1')
                dfs(grid, adj.x, adj.y, seen);
        }
    }

    private List<Position> getAdjacent(int i, int j) {
        List<Position> result = new ArrayList<>();
        if (i - 1 >=0) result.add(new Position(i - 1, j));
        if (i + 1 < rows) result.add(new Position(i + 1, j));
        if (j - 1 >= 0) result.add(new Position(i, j - 1));
        if (j + 1 < cols) result.add(new Position(i, j + 1));
        return  result;
    }

    class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
