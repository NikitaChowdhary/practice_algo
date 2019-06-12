package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 *
 * One way to check if graph is a tree is check for number of incoming edge count and check the degree in the end for the edges
 * Other way to check if there is no cycle found in the graph
 *
 */


public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        int[] degree = new int[n];
        Map<Integer, List<Integer>> graph = getGraph(edges, degree);

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (degree[i] == 1) queue.add(i);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                int current = queue.poll();
                degree[current]--;
                for(int adj: graph.getOrDefault(current, new ArrayList<>())) {
                    degree[adj]--;
                    if (degree[adj] == 1) queue.add(adj);
                }
            }
        }

        boolean result = true;
        for (int i = 0; i< n; i++) {
            result = result & degree[i] <= 0;
        }
        return result;
    }

    private static Map<Integer, List<Integer>> getGraph(int[][] edges, int[] degree) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;

            List<Integer> adj = graph.getOrDefault(edge[0], new ArrayList<>());
            adj.add(edge[1]);
            graph.put(edge[0], adj);

            adj = graph.getOrDefault(edge[1], new ArrayList<>());
            adj.add(edge[0]);
            graph.put(edge[1], adj);
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] edge = {{0,1}, {0,2}, {0,3}, {1,4}};
        int[][] invalidEdge = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};

        int[][] empty  = {};
        System.out.println(validTree(1, empty));

    }
}
