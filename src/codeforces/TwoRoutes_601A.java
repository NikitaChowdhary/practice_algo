package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoRoutes_601A {

    // https://codeforces.com/problemset/problem/601/A

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] graphPoints = in.readLine().split(" ");

        int nodes = Integer.parseInt(graphPoints[0]);
        int edge = Integer.parseInt(graphPoints[1]);
        int[][] graph = new int[nodes][nodes];

        for (int i = 0; i< edge; i++) {
            String[] egdePoints = in.readLine().split(" ");
            int start = Integer.parseInt(egdePoints[0]) - 1;
            int end = Integer.parseInt(egdePoints[1]) - 1;

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        // Calculate path cost for train
        int vehicle = 1;
        // If there a path for train from 1-> N then calculate cost for road
        if (graph[0][nodes - 1] == 1) vehicle = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        boolean[] visited = new boolean[graph.length];
        visited[0] = true;
        int cost = getCost(vehicle, graph, queue, visited);
        System.out.println(cost);
    }


    private static int getCost(int vehicle, int[][] graph, Queue<Integer> queue, boolean[] visited) {
        int[] dist = new int[graph.length];

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (current == graph.length -1 ) return dist[current];
            for (int i = 0; i< graph.length; i++) {
                int adjacent = graph[current][i];
                if (adjacent == vehicle && !visited[i]) {
                    dist[i] = dist[current] + 1;
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }
        return -1;
    }
}
