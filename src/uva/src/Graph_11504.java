package uva.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by nikitachowdhary on 09/11/2017.
 */
public class Graph_11504 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cases = "";
        while((cases = reader.readLine())!= null && cases.length()!=0) {
            for (int i = 1; i <= Integer.parseInt(cases); i++) {
                String[] input = reader.readLine().split(" ");
                int nodes = Integer.parseInt(input[0]);
                int edges = Integer.parseInt(input[1]);
                Map<Integer, List<Integer>> graph = new HashMap<>();

                for (int k = 1; k <= edges; k++) {
                    String[] edge = reader.readLine().split(" ");
                    int start = Integer.parseInt(edge[0]);
                    int end = Integer.parseInt(edge[1]);

                    List<Integer> adjacent = new LinkedList<>();
                    if(graph.containsKey(start)) {
                        adjacent = graph.get(start);
                    }
                    adjacent.add(end);
                    graph.put(start, adjacent);
                }
                System.out.println(connectedComponents(graph, nodes));
            }
        }
    }

    private static int connectedComponents(Map<Integer, List<Integer>> graph, int nodes) {
        List<Integer> visited = new LinkedList<>();
        for ( int i = 1; i<= nodes ; i++) {
            if(!visited.contains(i))
                dfs(graph, visited,  i);
        }

        Map<Integer, List<Integer>> transpose = getTransposedGraph(graph);

        System.out.println(graph);
        System.out.println(transpose);
        List<Integer> transposeVisited = new LinkedList<>();
        int totalComponents = 0;
        for ( int i = visited.size() - 1; i>=0; i-- ) {
            int current = visited.get(i);
            if(!transposeVisited.contains(current)) {
                totalComponents++;
                dfs(transpose, transposeVisited, current);
                System.out.println(transposeVisited);
                int[] test = new int[2];
                return test.length;
//                test[]
            }
        }
        return totalComponents;
    }

    private static Map<Integer,List<Integer>> getTransposedGraph(Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> transpose = new HashMap<>();
        for(int end: graph.keySet()) {
            for(int start: graph.get(end)) {
                List<Integer> list = new LinkedList<>();
                if(transpose.containsKey(start))
                    list = transpose.get(start);
                list.add(end);
                transpose.put(start, list);
            }
        }
        return transpose;
    }

    private static void dfs (Map<Integer, List<Integer>> graph, List<Integer> visited, int start) {
        visited.add(start);
        if(graph.containsKey(start)) {
            for (int current: graph.get(start)) {
                if(!visited.contains(current))
                    dfs(graph, visited, current);
            }
        }
    }

}
