package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentShoeLaces_129B {
    // https://codeforces.com/problemset/problem/129/B

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int students = Integer.parseInt(inputs[0]);
        int laces = Integer.parseInt(inputs[1]);
        Map<Integer, List<Integer>> tied_up = generate_tieups(in, laces);
        Map<Integer, Lace> incoming = new HashMap<>();
        PriorityQueue<Lace> queue = set_incoming_count(tied_up, incoming);

        System.out.println(getGroupCount(tied_up, queue, incoming));
    }

    private static int getGroupCount(Map<Integer, List<Integer>> tied_up, PriorityQueue<Lace> queue, Map<Integer, Lace> incoming) {
        int count = 0;
        int currentLength = -1;
        while(!queue.isEmpty()) {
            Lace current = queue.poll();
            incoming.remove(current.student);
            System.out.println("Removed " + current.student + " with incoming edge " + current.incoming);
            if (current.incoming == 1) {
                List<Integer> adjacent = tied_up.getOrDefault(current.student, new LinkedList<>());
                if (adjacent.size() != currentLength) {
                    count++;
                    currentLength = adjacent.size();
                }
                for (int adj : adjacent) {
                    if (incoming.containsKey(adj)) {
                        Lace existingIncoming = incoming.get(adj);
                        queue.remove(existingIncoming);
                        Lace newIncoming = new Lace(existingIncoming.student, existingIncoming.incoming - 1);
                        queue.add(newIncoming);
                        incoming.put(adj, newIncoming);
                    }
                }
            }
        }
        return count;
    }

    private static PriorityQueue<Lace> set_incoming_count(Map<Integer, List<Integer>> tied_up, Map<Integer, Lace> incoming) {
        Comparator<Lace> comp = new Comparator<Lace>() {
            @Override
            public int compare(Lace o1, Lace o2) {
                if (o1.incoming < o2.incoming) return -1;
                else if (o1.incoming == o2.incoming) return 0;
                else return 1;
            }
        };
        PriorityQueue<Lace> queue = new PriorityQueue<>(comp);
        for (int i: tied_up.keySet()) {
            Lace l = new Lace(i, tied_up.getOrDefault(i, new LinkedList<>()).size());
            queue.add(l);
            incoming.put(i, l);
        }
        return queue;
    }


    // This case its a bi-directional graph hence we do not need to take transpose of the graph to get incoming edge count
    private static Map<Integer, List<Integer>> generate_tieups(BufferedReader in, int laces) throws IOException {
        Map<Integer, List<Integer>> tied_up = new HashMap<>();
        for (int i = 0; i < laces; i++) {
            String[] ties = in.readLine().split(" ");
            int start = Integer.parseInt(ties[0]);
            int end = Integer.parseInt(ties[1]);

            set_graph(tied_up, start, end);
            set_graph(tied_up, end, start);
        }
        return tied_up;
    }

    private static void set_graph(Map<Integer, List<Integer>> tied_up, int start, int end) {
        List<Integer> adjacent = tied_up.getOrDefault(start, new LinkedList<>());
        adjacent.add(end);
        tied_up.put(start, adjacent);
    }

    static class Lace {
        int student;
        int incoming;
        Lace(int student, int incoming) {
            this.incoming = incoming;
            this.student = student;
        }
    }
}
