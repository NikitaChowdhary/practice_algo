package leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite {
    static int requiredColor = 1; // Either 1 or -1

    public static boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return false;

        int[] color = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                color[i] = requiredColor;
                queue.add(i);
                if (!checkGraph(graph, color, visited, queue)) return false;
            }
        }

        return true;
    }

    private static boolean checkGraph(int[][] graph, int[] color, boolean[] visited, Queue<Integer> queue) {
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int currentColor = color[current];
            visited[current] = true;
            requiredColor = -1 * currentColor;

            for (int adj: graph[current]) {
                if (!visited[adj]) {
                    if (color[adj] != 0 && color[adj] == -1 * requiredColor)
                        return false;
                    queue.add(adj);
                    color[adj] = requiredColor;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3}, {0,2}, { 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }

}
