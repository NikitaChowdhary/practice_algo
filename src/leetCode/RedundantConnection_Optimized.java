package leetCode;

import java.util.Arrays;

public class RedundantConnection_Optimized {

    public int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        else return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int x_parent = find(parent, x);
        int y_parent = find(parent, y);

        parent[x_parent] = y_parent;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);

        int[] res = new int[2];

        for (int[] edge: edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if (x == y)
                res = edge;
            else union(parent, edge[0], edge[1]);
        }
        return res;

    }
}
