package pending_code.leetcode;

import java.util.*;

public class CheapestFlight_787 {
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/


    class Cost {
        int dest;
        int c;
        int stops;
        Cost(int dest, int c, int stops) {
            this.dest = dest;
            this.c = c;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        for(int i = 0; i<n; i++)
            cost[i] = Integer.MAX_VALUE;

        Map<Integer, List<Cost>> graph = getGraph(flights);

        Queue<Cost> queue = new ArrayDeque<>();
        queue.add(new Cost(src, 0, 0));
        cost[src] = 0;

        while(!queue.isEmpty()) {
            Cost current = queue.poll();

            if (current.dest == dst && current.stops == (K + 1)) break;
            for (Cost adjacent: graph.getOrDefault(current.dest, new LinkedList<>())) {
                if (cost[adjacent.dest] - cost[current.dest] > adjacent.c) {
                    cost[adjacent.dest] = cost[current.dest] + adjacent.c;
                    Cost updated = new Cost(adjacent.dest, cost[adjacent.dest], current.stops + 1);
                    queue.add(updated);
                }

            }
        }

        if (cost[dst] != Integer.MAX_VALUE) return cost[dst];
        else return -1;

    }

    private Map<Integer, List<Cost>> getGraph(int[][] flights) {
        Map<Integer, List<Cost>> graph = new HashMap<>();
        for (int i = 0; i< flights.length; i++) {
            int start = flights[i][0];
            int end = flights[i][1];
            int c = flights[i][2];
            List<Cost> adj = graph.getOrDefault(start, new LinkedList<>());
            adj.add(new Cost(end, c, 0));
            graph.put(start, adj);
        }
        return graph;
    }

    public static void main(String[] args) {

        int cities = 4;
        int src = 0;
        int dest = 3;
        int stops = 1;

        int[][] flights3 = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
//        int cities = 5;
//        int src = 2;
//        int dest = 1;
//        int stops = 1;
        int[][] flights2 = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
//        int cities = 3;
//        int src = 0;
//        int dest = 2;
//        int stops = 0;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        System.out.println(new CheapestFlight_787().findCheapestPrice(cities, flights3, src, dest, stops));
    }
}
