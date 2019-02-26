package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ValidBFS_1037D {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);

        Map<Integer, Set<Integer>> graph = getGraph(in, nodes - 1);

        String[] bfs = in.readLine().split(" ");
        boolean[] visited = new boolean[nodes + 1];
        if (isValid(graph, visited, bfs, nodes))
            System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isValid(Map<Integer, Set<Integer>> graph, boolean[] visited, String[] bfs, int nodes) {
        int currenPos = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(Integer.parseInt(bfs[currenPos]));
        if (!bfs[currenPos].equals("1")) return false;
        currenPos++;


        while(!queue.isEmpty()) {
            int current = queue.poll();

            Set<Integer> adjacent = graph.getOrDefault(current, new HashSet<>());
            while(currenPos < bfs.length) {
                int bfsCurrent = Integer.parseInt(bfs[currenPos]);
                if (adjacent.contains(bfsCurrent)) {
                    queue.add(bfsCurrent);
                    currenPos++;
                } else break;
            }

            visited[current] = true;
        }
        return currenPos == bfs.length;
    }


    private static Map<Integer, Set<Integer>> getGraph(BufferedReader in, int edges) throws IOException {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i< edges; i++) {
            String[] edge = in.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);

            Set<Integer> adj = graph.getOrDefault(start, new HashSet<>());
            adj.add(end);
            graph.put(start, adj);

            adj = graph.getOrDefault(end, new HashSet<>());
            adj.add(start);
            graph.put(end, adj);

        }
        return graph;
    }
}
