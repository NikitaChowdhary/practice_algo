package leetCode;

import java.util.*;

public class NetworkDelayTime_743 {

    int maxCost = 1000000;
    class Edge {
        int node;
        int cost;
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        setGraph(times, graph);

        Map<Integer, Edge> mapping = new HashMap<>();
        PriorityQueue<Edge> queue = initializeNodes(N, mapping, K);

        int cost = 0;
        while(!queue.isEmpty()) {
            Edge current = queue.poll();
            mapping.remove(current.node);

            if (current.cost == maxCost) cost = -1;
            else cost = Math.max(cost, current.cost);

            for (Edge adjacentGraphNode: graph.getOrDefault(current.node, new LinkedList<>())) {
                if (mapping.containsKey(adjacentGraphNode.node)) {
                    Edge queuedAdjacent = mapping.get(adjacentGraphNode.node);
                    if (queuedAdjacent.cost > adjacentGraphNode.cost + current.cost) {
                        queue.remove(queuedAdjacent);
                        queuedAdjacent = new Edge(adjacentGraphNode.node, adjacentGraphNode.cost + current.cost);
                        queue.add(queuedAdjacent);
                        mapping.put(adjacentGraphNode.node, queuedAdjacent);
                    }
                }
            }
        }
        return cost;

    }

    private PriorityQueue<Edge> initializeNodes(int n, Map<Integer, Edge> mapping, int start) {
        Comparator<Edge> comp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.cost < o2.cost) return -1;
                else if (o1.cost == o2.cost) return 0;
                else return 1;
            }
        };
        PriorityQueue<Edge> queue = new PriorityQueue<>(comp);

        for (int i= 1; i<=n; i++) {
            int cost = maxCost;
            if (i == start) cost = 0;
            Edge edge = new Edge(i, cost);
            queue.add(edge);
            mapping.put(i, edge);
        }
        return queue;
    }

    private void setGraph(int[][] times, Map<Integer, List<Edge>> graph) {
        for (int i =0; i< times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            int cost = times[i][2];
            List<Edge> adj = graph.getOrDefault(start, new LinkedList<>());
            adj.add(new Edge(end, cost));
            graph.put(start, adj);
        }
    }


    public static void main(String[] args) {

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};

        System.out.println(new NetworkDelayTime_743().networkDelayTime(times, 4, 2));


    }
}
