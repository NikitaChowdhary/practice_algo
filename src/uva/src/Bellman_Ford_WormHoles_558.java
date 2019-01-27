package uva.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bellman_Ford_WormHoles_558 {
    // https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=7&problem=499

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        while(cases-- != 0) {
            String[] input = in.readLine().split(" ");
            int vertices = Integer.parseInt(input[0]);
            int edges = Integer.parseInt(input[1]);
            int[][] wormholes = setEdges(in, edges);
            if(bellmanFord(vertices, wormholes))
                System.out.println("possible");
            else
                System.out.println("not possible");

        }
    }

    private static boolean bellmanFord(int vertices, int[][] wormholes) {
        int[] cost = new int[vertices];
        for (int i = 0; i< vertices; i++) cost[i] = Integer.MAX_VALUE;

        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j< wormholes.length; j++) {
                int start = wormholes[j][0];
                int end = wormholes[j][1];
                int c = wormholes[j][2];
                if (cost[end] - cost[start] > c)
                    cost[end] = cost[start] + c;
            }
        }

        for (int j = 0; j< wormholes.length; j++) {
            int start = wormholes[j][0];
            int end = wormholes[j][1];
            int c = wormholes[j][2];
            if (cost[end] - cost[start] > c)
                return true;
        }
        return false;
    }

    private static int[][] setEdges(BufferedReader in, int edges) throws IOException {
        int[][] wormholes = new int[edges][3];
        for (int i = 0; i< edges; i++) {
            String[] edge = in.readLine().split(" ");
            wormholes[i][0] = Integer.parseInt(edge[0]);
            wormholes[i][1] = Integer.parseInt(edge[1]);
            wormholes[i][2] = Integer.parseInt(edge[2]);
        }
        return wormholes;
    }
}
