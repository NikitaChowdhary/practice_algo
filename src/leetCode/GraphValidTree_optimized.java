package leetCode;

import java.util.Arrays;

public class GraphValidTree_optimized {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        for (int[] edge: edges) {
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);

            if (x == y) return false;
            else union(parent, edge[0], edge[1]);
        }
        return true;
    }

    private void union(int[] parent, int x, int y) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        parent[x_parent] = y_parent;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == -1 ) return i;
        else return find(parent[i], parent);
    }


}
