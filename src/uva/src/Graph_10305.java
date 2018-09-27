package uva.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph_10305 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = reader.readLine();
            if(input.equals("0 0")) break;
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int vertices = setup(graph, reader, input);
            List<Integer> ordered = getOrderedTask(vertices, graph);
            for (int i = ordered.size() - 1; i >=0; i--)
                System.out.print(ordered.get(i) + " ");
            System.out.println();
        }
    }

    private static List<Integer> getOrderedTask(int vertices, Map<Integer, List<Integer>> graph) {
        List<Integer> result = new LinkedList<>();
        for ( int i =1; i<=vertices; i++) {
            if (!result.contains(i)) {
                dfs(graph, i, result);
            }
        }
        return result;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int i, List<Integer> result) {
        if(graph.containsKey(i)) {
            for (int current : graph.get(i)) {
                if (!result.contains(current)) {
                    dfs(graph, current, result);
                }
            }
        }
        result.add(i);
    }

    private static int setup(Map<Integer, List<Integer>> graph, BufferedReader reader, String input) throws IOException {
        String[] data = input.split(" ");
        int vertices = Integer.parseInt(data[0]);
        int edge = Integer.parseInt(data[1]);
        while(edge-- != 0) {
            String[] edges = reader.readLine().split(" ");
            int start = Integer.parseInt(edges[0]);
            int end = Integer.parseInt(edges[1]);
            List<Integer> adjacenyList = new LinkedList<>();
            if (graph.containsKey(start))
                adjacenyList = graph.get(start);
            adjacenyList.add(end);
            graph.put(start, adjacenyList);
        }
        return vertices;
    }
}
