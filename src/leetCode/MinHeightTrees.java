package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinHeightTrees {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        int[] degree = new int[n];
        graph = getGraph(edges, degree);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i<n; i++) {
            if (degree[i] == 0) return result;
            else if (degree[i] == 1) queue.add(i);
        }

        while(!queue.isEmpty()) {
            result.clear();
            int size = queue.size();

            for (int i = 0; i< size; i++) {
                int current = queue.poll();
                result.add(current);
                degree[current]--;

                for (int adj: graph.getOrDefault(current, new ArrayList<>())) {
                    degree[adj]--;
                    if (degree[adj] == 1) queue.add(adj);
                }
            }
        }

        return result;


    }

    private Map<Integer, List<Integer>> getGraph(int[][] edges, int[] degree) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            List<Integer> temp = graph.getOrDefault(edge[0], new ArrayList<>());
            temp.add(edge[1]);
            graph.put(edge[0], temp);

            temp = graph.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            graph.put(edge[1], temp);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        return graph;
    }
}
