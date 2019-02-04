package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentShoeLaces_129B {

    // https://codeforces.com/problemset/problem/129/B
    static int students;
    static int laces;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        students = Integer.parseInt(inputs[0]);
        laces = Integer.parseInt(inputs[1]);

        int[] incoming = new int[students + 1];
        Map<Integer, List<Integer>> tied_up = generate_tieups(in, incoming);

        System.out.println(getGroupCount(tied_up, incoming));
    }

    private static int getGroupCount(Map<Integer, List<Integer>> tied_up, int[] incoming) {
        int count = 0;

        while(true) {
            List<Integer> nodes = new ArrayList<>();
            for (int i = 1; i< incoming.length; i++) {
                if (incoming[i] == 1)
                    nodes.add(i);
            }
            if (nodes.isEmpty())
                break;
            else {
                count++;
                for (int n: nodes) {
                    incoming[n]--;
                    for (int adj: tied_up.getOrDefault(n, new ArrayList<>())) {
                        incoming[adj]--;
                    }
                }
            }
        }
        return count;
    }

    private static Map<Integer, List<Integer>> generate_tieups(BufferedReader in, int[] incoming) throws IOException {
        Map<Integer, List<Integer>> tied_up = new HashMap<>();
        for (int i = 0; i < laces; i++) {
            String[] ties = in.readLine().split(" ");
            int start = Integer.parseInt(ties[0]);
            int end = Integer.parseInt(ties[1]);

            set_graph(tied_up, start, end);
            set_graph(tied_up, end, start);
            incoming[start]++;
            incoming[end]++;
        }
        return tied_up;
    }

    private static void set_graph(Map<Integer, List<Integer>> tied_up, int start, int end) {
        List<Integer> adjacent = tied_up.getOrDefault(start, new ArrayList<>());
        adjacent.add(end);
        tied_up.put(start, adjacent);
    }
}
