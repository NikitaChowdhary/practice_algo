package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] res = new int[2];
        for (int[] edge: edges) {
            boolean[] visited = new boolean[edges.length + 1];
            if (graph.containsKey(edge[0]) && graph.containsKey(edge[1]) && dfs(graph, visited, edge[0], edge[1]))
                res = edge;

            List<Integer> adj = graph.getOrDefault(edge[0], new ArrayList<>());
            adj.add(edge[1]);
            graph.put(edge[0], adj);

            adj = graph.getOrDefault(edge[1], new ArrayList<>());
            adj.add(edge[0]);
            graph.put(edge[1], adj);
        }
        return res;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, int end) {
        if (!visited[start]) {
            visited[start] = true;
            if (start == end) return true;
            for (int adj: graph.getOrDefault(start, new ArrayList<>())) {
                if (dfs(graph, visited, adj, end)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2}, {1,3},{2,3}};//{{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        for (int r: findRedundantConnection(input))
            System.out.println(r);
    }
}
