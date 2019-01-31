package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NewYearTrans_500A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);
        int dest = Integer.parseInt(inputs[1]);
        
        String[] path = in.readLine().split(" ");
        Map<Integer, List<Integer>> transporation = setMap(path);
        boolean[] visited = new boolean[nodes + 1];
        dfs(1, transporation, visited);
        if (visited[dest])
            System.out.println("YES");
        else System.out.println("NO");
        
    }

    private static void dfs(int i, Map<Integer, List<Integer>> transporation, boolean[] visited) {
        visited[i] = true;
        for (int adj: transporation.getOrDefault(i, new LinkedList<>())) {
            if (!visited[adj])
                dfs(adj, transporation, visited);
        }
    }

    private static Map<Integer, List<Integer>> setMap(String[] path) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i< path.length; i++) {
            int start = i + 1;
            int end = start + Integer.parseInt(path[i]);
            List<Integer> adj = map.getOrDefault(start, new LinkedList<>());
            adj.add(end);
            map.put(start, adj);
        }
        return map;
    }
}
