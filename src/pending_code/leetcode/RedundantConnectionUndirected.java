package pending_code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class RedundantConnectionUndirected {

    public boolean findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = generateGraphFromInput(edges);
        // For each node do DFS and check if the cycle can be found
        boolean[] visited = new boolean[edges.length + 1];
        boolean[] stackNodes = new boolean[edges.length + 1];
        System.out.println("Number of nodes " + edges.length);
        System.out.println("Nodes with start point "+ graph.size());
        boolean result = false;
        for (int i = 1; i <= edges.length; i++) {
            if (!visited[i])
                result = dfs(i, visited, stackNodes, graph);
        }
        return result;
    }

    private boolean dfs(int i, boolean[] visited, boolean[] stackNodes, Map<Integer, List<Integer>> graph) {
        visited[i] = true;

        stackNodes[i] = true;

        for (int adjacent: graph.getOrDefault(i, new LinkedList<>())) {
            if (!visited[adjacent]) {
                return dfs(adjacent, visited, stackNodes, graph);
            } else {
                System.out.println("I am smart");
                System.out.println("Nodes which can be removed " + i + " " + adjacent);
                return true;
            }
        }
        stackNodes[i]  = false;
        return false;

    }

    private Map<Integer, List<Integer>> generateGraphFromInput(int[][] edges) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            List<Integer> adjacent = result.getOrDefault(start, new LinkedList<>());
            adjacent.add(end);
            result.put(start, adjacent);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String edges = in.readLine();
        int edgeCount = Integer.parseInt(edges);
        int[][] input = new int[edgeCount][2];
        while (!edges.equals("*")) {

            for (int i = 0; i< Integer.parseInt(edges); i++) {
                String[] edge = in.readLine().split(" ");
                int[] edgeGenerated = {Integer.parseInt(edge[0]), Integer.parseInt(edge[1])};
                input[i] = edgeGenerated;
            }

            System.out.println(new RedundantConnectionUndirected().findRedundantDirectedConnection(input));


            edges = in.readLine();
            edgeCount = Integer.parseInt(edges);
            input = new int[edgeCount][2];

        }


    }


}