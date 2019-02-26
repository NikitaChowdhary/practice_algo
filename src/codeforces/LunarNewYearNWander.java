package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LunarNewYearNWander {
    // https://codeforces.com/problemset/problem/1106/D
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);
        int edges = Integer.parseInt(inputs[1]);

        Map<Integer, List<Integer>> graph = getGraph(in, edges);
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[nodes + 1];
        getOrder(graph, visitedOrder, visited, nodes);
        for(int i: visitedOrder)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void getOrder(Map<Integer, List<Integer>> graph, List<Integer> visitedOrder, boolean[] visited, int nodes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            visitedOrder.add(current);

            for (int adj: graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    private static Map<Integer,List<Integer>> getGraph(BufferedReader in, int edges) throws IOException {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i< edges; i++) {
            String[] edge = in.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);

            List<Integer> adj = graph.getOrDefault(start, new ArrayList<>());
            adj.add(end);
            graph.put(start, adj);

            adj = graph.getOrDefault(end, new ArrayList<>());
            adj.add(start);
            graph.put(end, adj);

        }
        return graph;
    }
}
