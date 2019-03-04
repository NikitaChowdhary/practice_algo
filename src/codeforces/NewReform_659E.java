package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NewReform_659E {

    private static boolean isCyclic = false;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);
        int edges = Integer.parseInt(inputs[1]);

        Map<Integer, List<Integer>> graph = getGraph(in, edges);
        boolean[] visited = new boolean[nodes + 1];

        int count = 0;
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                hasCycle(i, graph, visited, -1);
                if (!isCyclic) count++;
                isCyclic = false;
            }
        }
        System.out.println(count);
    }

    private static void hasCycle(int start, Map<Integer, List<Integer>> graph, boolean[] visitedTrack, int parent) {

        visitedTrack[start] = true;
        for (int i : graph.getOrDefault(start, new LinkedList<>())) {
            if (!visitedTrack[i])
                hasCycle(i, graph, visitedTrack, start);
            else if (i != parent) isCyclic = true;
        }
    }


    private static Map<Integer, List<Integer>> getGraph(BufferedReader in, int edges) throws IOException {
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
