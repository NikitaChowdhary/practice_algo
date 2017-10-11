import common.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by nikitachowdhary on 11/10/2017.
 */
public class Graph_10004 {
    static class Pair {
        int a;
        boolean color;
        Pair(int a, boolean c){
            this.a = a;
            this.color = c;
        }
    }


    private static Map<Integer, Boolean> isVisitedColor = new HashMap<Integer, Boolean>();
    private static Queue<Pair> visited = new LinkedList<Pair>();
    private static Graph graph = new Graph();

    private static boolean isBicolorable(Graph graph) {
        visited.add(new Pair(0,false));
        isVisitedColor.put(0, false);
        while(!visited.isEmpty()) {
            Pair current = visited.poll();
            if (graph.adjacenyList.containsKey(current.a)) {
                List<Integer> adjacent = graph.adjacenyList.get(current.a);
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
        while(true) {
            resetResources();
            int nodes = Integer.parseInt(reader.readLine());
            if(nodes == 0) break;
            int edges = Integer.parseInt(reader.readLine());
            while(edges-- != 0) {
                String[] edge = reader.readLine().split(" ");
                List<Integer> adjacentNodes = new LinkedList<>();
                int start_vertex = Integer.parseInt(edge[0]);
                int end_vertex = Integer.parseInt(edge[1]);
                if (graph.adjacenyList.containsKey(start_vertex)) {
                    adjacentNodes = graph.adjacenyList.get(start_vertex);
                }
                adjacentNodes.add(end_vertex);
                graph.adjacenyList.put(start_vertex, adjacentNodes);
            }
            if(isBicolorable(graph))
                System.out.println("BICOLORABLE.");
            else
                System.out.println("NOT BICOLORABLE.");
        }
    }

    private static void resetResources() {
        isVisitedColor = new HashMap<Integer, Boolean>();
        visited = new LinkedList<Pair>();
        graph = new Graph();
    }

}
