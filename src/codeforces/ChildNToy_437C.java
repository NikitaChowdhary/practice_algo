package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChildNToy_437C {

    // https://codeforces.com/problemset/problem/437/C

    static int toys;
    static int ropes;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        toys = Integer.parseInt(inputs[0]);
        ropes = Integer.parseInt(inputs[1]);
        String[] node_energy = in.readLine().split(" ");
        System.out.println(getToy(in, node_energy));
    }


    private static int getToy(BufferedReader in, String[] node_energy) throws IOException {
        int cost = 0;
        for (int i = 0; i < ropes; i++) {
            String[] edge_string = in.readLine().split(" ");
            int start = Integer.parseInt(edge_string[0]);
            int end = Integer.parseInt(edge_string[1]);
            cost += Math.min(Integer.parseInt(node_energy[start - 1]), Integer.parseInt(node_energy[end - 1]));
        }
        return cost;
    }
}
