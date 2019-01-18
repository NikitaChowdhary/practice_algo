package hackerrank;

import java.io.IOException;
import java.util.*;

public class PrimsSpecial {

    static class Node {
        int weight;
        int val;
        Node(int weight, int val) {
            this.weight = weight;
            this.val = val;
        }
    }
    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {
        Map<Integer, Node> queueMapping = new HashMap<>();
        PriorityQueue<Node> queue = setPriorityQueue(n, start, queueMapping);

        Map<Integer, List<Node>> graph = setGraph(edges);
        int cost = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            queueMapping.remove(current.val);
            cost += current.weight;
//            System.out.println("Node added " + current.val + " with weight " +current.weight);

            for (Node adjacent : graph.get(current.val)) {
//                System.out.println("Adjacent nodes for " + current.val + " is " + adjacent.val);
                if (queueMapping.containsKey(adjacent.val)) {
                    Node queueNode = queueMapping.get(adjacent.val);
                    if (adjacent.weight < queueNode.weight) {
                        queue.remove(queueNode);

                        Node newnode = new Node(adjacent.weight, adjacent.val);
                        queue.add(newnode);
                        queueMapping.put(adjacent.val, newnode);

                    }
                }


            }
        }

    return cost;
    }

    private static Map<Integer, List<Node>> setGraph(int[][] edges) {
        Map<Integer, List<Node>> graph = new HashMap<>();
//        System.out.println(edges.length);
        for (int i = 0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];

            List<Node> adj = graph.getOrDefault(start, new LinkedList<>());
            adj.add(new Node(weight, end));
            graph.put(start, adj);
//
            adj = graph.getOrDefault(end, new LinkedList<>());
            adj.add(new Node(weight, start));
            graph.put(end, adj);

        }
        return graph;
    }

    private static PriorityQueue<Node> setPriorityQueue(int n, int start, Map<Integer, Node> nodemapping) {
        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.weight < o2.weight) return -1;
                else if (o1.weight == o2.weight) return 0;
                else return 1;
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comp);
        for (int i = 1; i <=n; i++) {
            int w = Integer.MAX_VALUE;
            if (i == start)
                w = 0;
            Node no = new Node(w, i);
            queue.add(no);
            nodemapping.put(i, no);
        }

        return queue;
    }


    public static void main(String[] args) throws IOException {
        int n = 5;
        int[][] edges = {{1, 2, 3}, {1, 3, 4}, {4, 2, 6}, {5, 2, 2}, {2, 3, 5}, {3, 5, 7}};
        System.out.println(prims(n, edges, 1));
    }
}

