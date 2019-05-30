package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class UnconnectedComponents {

    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> graph = getGraph(edges);

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        for (int adj : graph.getOrDefault(start, new ArrayList<>( ))){
            if (!visited[adj])
                dfs(adj, graph, visited);
        }
    }

    private Map<Integer, List<Integer>> getGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

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
