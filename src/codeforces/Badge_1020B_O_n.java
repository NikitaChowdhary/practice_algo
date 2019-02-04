package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Badge_1020B_O_n {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(in.readLine());

        // Can I use Map<Integer, Integer> instead as there is always going to be one out edge
        Map<Integer, List<Integer>> studentBlames = new HashMap<>();
        int[] doublePunch = new int[studentCount + 1];
        int start = 1;
        for (String s: in.readLine().split(" ")) {
            List<Integer> adjacent = studentBlames.getOrDefault(start, new LinkedList<>());
            adjacent.add(Integer.parseInt(s));
            studentBlames.put(start, adjacent);
            start++;
        }

        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 1; i<= studentCount; i++) {
            List<Integer> currentCycle = new LinkedList<>();
            if (!visited.containsKey(i)){
                if (hasCycle(studentBlames, i, visited, currentCycle)) {
                    for (int current: currentCycle) {
                        doublePunch[current] = current;
                    }
                }
            }
        }

        for (int i =1; i<= studentCount; i++)
            System.out.print(doublePunch[i] + " ");
        System.out.println();

    }

    static boolean hasCycle(Map<Integer, List<Integer>> blameGraph, int start, Map<Integer, Integer> visited, List<Integer> currentCycle) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        currentCycle.add(start);
        visited.put(start, start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int adj: blameGraph.getOrDefault(current, new LinkedList<>())) {
                if (!visited.containsKey(adj)){
                    queue.add(adj);
                    currentCycle.add(adj);
                }
                else if (visited.get(adj) == start)
                    return true;
            }
            visited.put(current, start);
        }

        return false;
    }
}
