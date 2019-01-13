package GFGeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TotalX {
    private static char[][] graph;
    private static boolean[][] visited;
    private static int row;
    private static int col;

    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-- != 0) {
            String[] input = in.readLine().split(" ");
            row = Integer.parseInt(input[0]);
            col = Integer.parseInt(input[1]);
            graph = new char[row][col];

            String[] shapes = in.readLine().split(" ");
            for (int i = 0; i< shapes.length; i++) {
                for (int j = 0; j< col; j++) {
                    graph[i][j] = shapes[i].charAt(j);
                }
            }

            visited = new boolean[row][col];
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visited[i][j] && graph[i][j] =='X') {
                        getConnected(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        //code
    }

    private static void getConnected(int i, int j) {

        Queue<Coordinates> queue = new ArrayDeque<>();

        queue.add(new Coordinates(i, j));
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            Coordinates current = queue.poll();
            for(Coordinates adj: getAdjacent(current)) {
                queue.add(adj);
                visited[adj.i][adj.j] = true;
            }
            queue.addAll(getAdjacent(current));
        }

    }

    private static List<Coordinates> getAdjacent(Coordinates current) {
        List<Coordinates> adjacent = new LinkedList<>();
        // Left
        if (isValidAdjacent(current.i - 1 ,current.j))
            adjacent.add(new Coordinates(current.i - 1, current.j));
        // Right
        if (isValidAdjacent(current.i + 1, current.j))
            adjacent.add(new Coordinates(current.i + 1, current.j));
        // Up
        if (isValidAdjacent(current.i , current.j - 1))
            adjacent.add(new Coordinates(current.i , current.j - 1));
        if (isValidAdjacent(current.i , current.j + 1))
            adjacent.add(new Coordinates(current.i , current.j + 1));
        return adjacent;
    }

    private static boolean isValidAdjacent(int i, int j) {
        return (i >= 0 && i < row
                && j >= 0 && j< col
                && graph[i][j] == 'X'
                && !visited[i][j]);
    }

    static class Coordinates {
        int i;
        int j;
        public Coordinates(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
