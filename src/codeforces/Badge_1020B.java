package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Badge_1020B {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(in.readLine());

        // Can I use Map<Integer, Integer> instead as there is always going to be one out edge
        Map<Integer, List<Integer>> blameGraph = new HashMap<>();
        int[] doublePunch = new int[studentCount + 1];
        int start = 1;
        for (String s: in.readLine().split(" ")) {
            List<Integer> adjacent = blameGraph.getOrDefault(start, new LinkedList<>());
            adjacent.add(Integer.parseInt(s));
            blameGraph.put(start, adjacent);
            start++;
        }

        for (int firstStudent = 1; firstStudent <= studentCount; firstStudent++) {
            boolean[] visited = new boolean[studentCount + 1];
            int punchedTwice = bfs(firstStudent, blameGraph, visited);
            doublePunch[firstStudent] = punchedTwice;
        }

        for (int i =1; i<= studentCount; i++)
            System.out.print(doublePunch[i] + " ");
        System.out.println();

    }

    private static int bfs(int firstStudent, Map<Integer, List<Integer>> blameGraph, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(firstStudent);
        while(!queue.isEmpty()) {
            int current = queue.poll();
//            if (visited[current]) return current;
            for (int adj: blameGraph.getOrDefault(current, new LinkedList<>())) {
                if (!visited[adj])
                    queue.add(adj);
                else return adj;
            }
            visited[current] = true;
        }
        return -1;
    }
}
