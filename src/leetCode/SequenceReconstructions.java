package leetCode;

import java.util.*;

// https://leetcode.com/problems/sequence-reconstruction/
public class SequenceReconstructions {

    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Integer> incoming = new HashMap<>();
        Map<Integer, List<Integer>> graph = getGraph(seqs, incoming);
        Queue<Integer> queue = new ArrayDeque<>();
        for(int key: incoming.keySet()) {
            if (incoming.get(key) == 0)
                queue.add(key);
        }
        List<Integer> result = new ArrayList<>();
        if (queue.size() > 1) return false;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            int currentAdded = 0;
            result.add(current);
            for (int adj: graph.getOrDefault(current, new ArrayList<>())) {
                int currentIncoming = incoming.getOrDefault(adj, 0) - 1;
                incoming.put(adj, currentIncoming);
                if (currentIncoming == 0) {
                    queue.add(adj);
                    currentAdded++;
                }
            }
            if (currentAdded >=2) return false;
        }

        if (result.size() != org.length || result.size() != graph.size()) return false;

        return true;
    }

    private static Map<Integer, List<Integer>> getGraph(List<List<Integer>> seqs, Map<Integer, Integer> incoming) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> seq: seqs) {
            for (int i = 0; i< seq.size(); i++) {
                int start = seq.get(i);
                List<Integer> adj = graph.getOrDefault(start, new ArrayList<>());
                 if (i + 1 < seq.size()) {
                     int end = seq.get(i + 1);
                     adj.add(end);
                     int currenCount = incoming.getOrDefault(end, 0);
                     incoming.put(end, currenCount + 1);
                 }
                 graph.put(start, adj);
                int count = incoming.getOrDefault(start, 0);
                incoming.put(start, count);

            }
        }
        return graph;
    }

    public static void main(String[] args) {
        List<List<Integer>> seqs = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1,3), Arrays.asList(2, 3), Arrays.asList(4, 2));

        int[] inp = {1, 4, 2, 3};
        System.out.println(sequenceReconstruction(inp, seqs));
    }
}
