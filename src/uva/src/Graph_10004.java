package uva.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_10004 {
    private static Map<Integer, Boolean> isVisitedColor = new HashMap<>();
    private static Queue<Pair> visited = new LinkedList<>();
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    private static boolean isBicolorable(Map<Integer, List<Integer>> graph) {
        visited.add(new Pair(0, false));
        isVisitedColor.put(0, false);
        while (!visited.isEmpty()) {
            Pair current = visited.poll();
            if (graph.containsKey(current.a)) {
                List<Integer> adjacent = graph.get(current.a);
                for (int node : adjacent) {
                    if (isVisitedColor.containsKey(node) && isVisitedColor.get(node) == current.color) {
                        return false;
                    } else if (!isVisitedColor.containsKey(node)) {
                        isVisitedColor.put(node, !current.color);
                        visited.add(new Pair(node, !current.color));
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            resetResources();
            int nodes = Integer.parseInt(reader.readLine());
            if (nodes == 0) break;
            int edges = Integer.parseInt(reader.readLine());
            while (edges-- != 0) {
                String[] edge = reader.readLine().split(" ");
                List<Integer> adjacentNodes = new LinkedList<>();
                int start_vertex = Integer.parseInt(edge[0]);
                int end_vertex = Integer.parseInt(edge[1]);
                if (graph.containsKey(start_vertex)) {
                    adjacentNodes = graph.get(start_vertex);
                }
                adjacentNodes.add(end_vertex);
                graph.put(start_vertex, adjacentNodes);
            }
            if (isBicolorable(graph))
                System.out.println("BICOLORABLE.");
            else
                System.out.println("NOT BICOLORABLE.");
        }
    }

    private static void resetResources() {
        isVisitedColor = new HashMap<>();
        visited = new LinkedList<>();
        graph = new HashMap<>();
    }

    static class Pair {
        int a;
        boolean color;

        Pair(int a, boolean c) {
            this.a = a;
            this.color = c;
        }
    }

}
