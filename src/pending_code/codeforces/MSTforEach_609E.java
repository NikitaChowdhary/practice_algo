package pending_code.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MSTforEach_609E {

    static int nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        nodes = Integer.parseInt(input[0]);

        List<Edge> allEdge = new ArrayList<>();
        Map<Integer, List<Cost>> graph = getGraph(in, Integer.parseInt(input[1]), allEdge);
        MST firstMST = generateFirstMST(graph, allEdge);
        System.out.println(firstMST.cost);
    }

    private static MST generateFirstMST(Map<Integer, List<Cost>> graph, List<Edge> allEdge) {
        MST mst = new MST(new HashSet<>(), 0);
        boolean[] visited = new boolean[nodes + 1];
        Collections.sort(allEdge);
        for (Edge current: allEdge) {
            if (mst.edge.isEmpty())
                visited[current.start] = true;
            if (!visited[current.end]) {
                mst.edge.add(current);
                mst.cost = mst.cost + current.cost;
                visited[current.end] = true;
            }
        }
        return mst;
    }

    private static Map<Integer, List<Cost>> getGraph(BufferedReader in, int edges, List<Edge> allEdge) throws IOException {

        Map<Integer, List<Cost>> graph = new HashMap<>();
        for (int i = 0; i< edges; i++) {
            String[] edge = in.readLine().split(" ");

            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);
            int cost = Integer.parseInt(edge[2]);

            allEdge.add(new Edge(start, end, cost));
            allEdge.add(new Edge(end, start, cost));

            List<Cost> adj = graph.getOrDefault(start, new ArrayList<>());
            adj.add(new Cost(end, cost));
            graph.put(start, adj);

            adj = graph.getOrDefault(end, new ArrayList<>());
            adj.add(new Cost(start, cost));
            graph.put(end, adj);
        }
        return graph;
    }

    static class Cost {
        int dest;
        int cost;
        Cost(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;
        Edge(int start, int end, int cost) {
           this.start = start;
           this.end = end;
           this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.valueOf(this.cost).compareTo(o.cost);
        }
    }

    static class MST {
        Set<Edge> edge;
        int cost;
        MST(Set<Edge> edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }
    }
}
