package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KingEscape_1033A {

    static Position minPostion;
    static Position maxPosition;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        String[] queenPosition = in.readLine().split(" ");
        String[] kingInitialPosition = in.readLine().split(" ");
        String[] kingFinalPosition = in.readLine().split(" ");

        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] positions = new int[n + 1][n + 1];
        Position checkPost = new Position(Integer.parseInt(queenPosition[0]), Integer.parseInt(queenPosition[1]));


        Position start = new Position(Integer.parseInt(kingInitialPosition[0]), Integer.parseInt(kingInitialPosition[1]));
        Position end = new Position(Integer.parseInt(kingFinalPosition[0]), Integer.parseInt(kingFinalPosition[1]));

        boolean result = setPositionsForKingArea(checkPost, start, end);
//        System.out.println(result);
//        System.out.println("Only looking here " + minPostion.x + " " + minPostion.y  + " end one is " + maxPosition.x + " " + maxPosition.y);
            if (end.x >= minPostion.x && end.x <= maxPosition.x && end.y >= minPostion.y && end.y <= maxPosition.y) {
                // If under same daigonal pos true
                // else bfs
//                bfs(checkPost, start, end, visited);

//                if (visited[end.x][end.y])
                    System.out.println("YES");
            }
            else System.out.println("NO");

    }

    private static boolean setPositionsForKingArea(Position checkPost, Position startKing, Position endKing) {
        if (startKing.x < checkPost.x && startKing.y < checkPost.y) { // Left bottom corner
            minPostion = new Position(1, 1);
            maxPosition = checkPost;
            if (((startKing.x - startKing.y > checkPost.x - checkPost.y) && (endKing.x - endKing.y > checkPost.x - checkPost.y))
                || ((startKing.x - startKing.y < checkPost.x - checkPost.y) && (endKing.x - endKing.y < checkPost.x - checkPost.y)))
                return true;
        }
        else if (startKing.x > checkPost.x && startKing.y > checkPost.y) { // Right top
            minPostion = checkPost;
            maxPosition = new Position(n, n);
            if (((startKing.x - startKing.y > checkPost.x - checkPost.y) && (endKing.x - endKing.y > checkPost.x - checkPost.y))
                    || ((startKing.x - startKing.y < checkPost.x - checkPost.y) && (endKing.x - endKing.y < checkPost.x - checkPost.y)))
                return true;
        }
        else if (startKing.x > checkPost.x && startKing.y < checkPost.y) { // Left Top
            minPostion = new Position(checkPost.x, 1);
            maxPosition = new Position(n, checkPost.y);
            if (((startKing.x + startKing.y > checkPost.x + checkPost.y) && (endKing.x + endKing.y > checkPost.x + checkPost.y))
                    || ((startKing.x + startKing.y < checkPost.x + checkPost.y) && (endKing.x + endKing.y < checkPost.x + checkPost.y)))
                return true;

        }
        else if (startKing.x < checkPost.x && startKing.y > checkPost.y) { // Right bottom
            minPostion = new Position(1, checkPost.y);
            maxPosition = new Position(checkPost.x, n);
            if (((startKing.x + startKing.y > checkPost.x + checkPost.y) && (endKing.x + endKing.y > checkPost.x + checkPost.y))
                    || ((startKing.x + startKing.y < checkPost.x + checkPost.y) && (endKing.x + endKing.y < checkPost.x + checkPost.y)))
                return true;
        }
        return false;
    }

    private static List<Position> getValidAdjacentMoves(Position current, Position checkPost, boolean[][] visited) {
        List<Position> adjacent = new LinkedList<>();
        int x = current.x;
        int y = current.y;


        // Right diaglon x-y == positional difference
        // Left diagonal x+y == positional sum

        for (int diffx = -1; diffx <=1; diffx++) {
            for (int diffy = -1; diffy <= 1; diffy++) {
                int new_x = x + diffx;
                int new_y = y + diffy;
                if (new_x != x || new_y != y) {
                    if (new_x >=minPostion.x && new_x <= maxPosition.x
                            && new_y >= minPostion.y && new_y <= maxPosition.y // Valid position on board

                            && new_x != checkPost.x && new_y != checkPost.y // Not in same row or column as queen
                            && (new_x - new_y) != (checkPost.x - checkPost.y) // Right diagonal
                            && (new_x + new_y) != (checkPost.x + checkPost.y)
                            && (!visited[new_x][new_y])) {
                        adjacent.add(new Position(new_x, new_y));
                    }
                }

            }
        }
        return adjacent;

    }

    private static void dfs(Position checkPost, Position current, Position end, boolean[][] visited) {
        System.out.println("Processing " + current.x + " " + current.y +" something fishy");
        visited[current.x][current.y] = true;
        if (current.equals(end)) return;

        List<Position> adjacent = getValidAdjacentMoves(current, checkPost, visited);
        for (Position adj: adjacent) {
            if (!visited[adj.x][adj.y])
                dfs(checkPost, adj, end, visited);
        }
    }

    private static void bfs(Position checkPost, Position start, Position end, boolean[][] visited) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        while(!queue.isEmpty()) {
            Position current = queue.poll();
            for (Position adj: getValidAdjacentMoves(current, checkPost, visited)){
                if (!visited[adj.x][adj.y])
                    queue.add(adj);
            }
            visited[current.x][current.y] = true;
            if (current.equals(end)) return;
        }
    }

    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Position obj) {
            return (obj.x == this.x && obj.y == this.y);
        }
    }
}
