package leetCode;

import java.util.*;
// https://leetcode.com/problems/find-eventual-safe-states/

public class FindEventualSafeState {
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> result = new ArrayList<>();
        int[] color = new int[graph.length];


        for (int i = 0; i< graph.length; i++) {
            if (dfs(graph, color, i))
                result.add(i);
        }
        return result;
    }

    private static boolean dfs(int[][] graph, int[] visited, int start) {
        if (visited[start] > 0)
            return (visited[start] == 2);
        visited[start] = 1;

        for (int adj: graph[start]) {
            if (visited[adj] == 2) continue;
            if (visited[adj] == 1 || !dfs(graph, visited, adj)) return false;
        }
        visited[start] = 2;
        return true;
    }

    public static void main(String[] args) {

        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
