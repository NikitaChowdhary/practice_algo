package leetCode;

import java.util.*;

public class SurroundedRegions {
    static int rows = 0, cols = 0;
    static boolean isInside = false;

    // https://leetcode.com/problems/surrounded-regions/

    public static void solve(char[][] board) {
        List<Position> results = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();
        rows = board.length;

        for (int i = 0; i< board.length; i++) {
            cols = board[i].length;
            for (int j = 0; j < board[i].length; j++) {
                isInside = true;
                List<Position> temp = new ArrayList<>();

                if (!visited.containsKey(i + " "+ j) && board[i][j] == 'O') {
                    dfs(board, i, j, temp, visited);
                    if (isInside)
                        results.addAll(temp);
                }

            }
        }

        for (Position r: results)
            board[r.x][r.y] = 'X';


    }

    private static void dfs(char[][] board, int i, int j, List<Position> temp, Map<String, Boolean> visited) {
        isInside = isInside && isInsidePoint(i, j);
        visited.put(i + " " + j, true);
        temp.add(new Position(i, j));

        for (Position adj: getAdjacentPostion(new Position(i, j))) {
            if (!visited.containsKey(adj.x + " " + adj.y) && board[adj.x][adj.y] == 'O') {
                dfs(board, adj.x, adj.y, temp, visited);
            }
        }
    }


    public static boolean isInsidePoint(int x, int y) {
        return (x != 0 && y != 0 && x != rows - 1 && y != cols - 1);
    }

    private static List<Position> getAdjacentPostion(Position current) {
        List<Position> result = new ArrayList<>();
        if (current.x > 0)
            result.add(new Position(current.x - 1, current.y));
        if (current.y > 0)
            result.add(new Position(current.x, current.y - 1));
        if (current.x < rows - 1)
            result.add(new Position(current.x + 1, current.y));
        if (current.y < cols - 1)
            result.add(new Position(current.x, current.y + 1));
        return result;

    }

    public static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] inp = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] inp1 = new char[][]{{}};
        char[][] inp2 = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        for (int i = 0; i< inp.length; i++) {
            for (int j = 0; j<inp.length; j++)
                System.out.print(inp[i][j]);
            System.out.println();
        }
        System.out.println();
        solve(inp2);
        for (int i = 0; i< inp2.length; i++) {
            for (int j = 0; j<inp2.length; j++)
                System.out.print(inp2[i][j]);
            System.out.println();
        }
    }
}
