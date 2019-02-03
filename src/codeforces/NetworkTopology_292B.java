package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkTopology_292B {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int nodes = Integer.parseInt(inputs[0]);
        int edges = Integer.parseInt(inputs[1]);

        int[] adjacentCount = new int[nodes + 1];
        for (int i =0; i< edges; i++) {
            String[] str = in.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);

            adjacentCount[start]++;
            adjacentCount[end]++;
        }

        int edgesCount1 = 0;
        int edgesCount2 = 0;
        int edgesCountx = 0;

        for (int i = 1; i < adjacentCount.length; i++) {
            int adj = adjacentCount[i];
            if (adj == 1) edgesCount1++;
            else if (adj == 2) edgesCount2++;
            else edgesCountx++;
        }

        if (edgesCount2 == nodes)
            System.out.println("ring topology");
        else if (edgesCount1 == 2 && edgesCount2 == nodes - 2)
            System.out.println("bus topology");
        else if (edgesCount1 == nodes - 1 && edgesCountx == 1)
            System.out.println("star topology");
        else
            System.out.println("unknown topology");

    }
}
