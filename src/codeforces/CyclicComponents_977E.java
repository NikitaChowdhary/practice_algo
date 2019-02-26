package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CyclicComponents_977E {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);
        int edges = Integer.parseInt(inputs[1]);

        Map<Integer, List<Integer>> graph = getGraph(in, edges);

        boolean[] visited = new boolean[nodes + 1];
        int count = 0;
        for (int i = 1; i<=nodes; i++) {
            if (!visited[i]) {
                if (isCyclic(graph, i, visited))
                    count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isCyclic(Map<Integer, List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int nodeCount = 0;
        boolean isCyclic = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            nodeCount++;
            if (graph.getOrDefault(current, new ArrayList<>()).size() != 2) isCyclic = false;
            for (int adj: graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited[adj])
                    queue.add(adj);
            }
            visited[current] = true;
        }
        return isCyclic && (nodeCount > 2);
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
