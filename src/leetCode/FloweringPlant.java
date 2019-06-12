package leetCode;

import java.util.*;

// https://leetcode.com/problems/flower-planting-with-no-adjacent/
// Stupid code
public class FloweringPlant {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        boolean stop = false;
        do {
            stop = true;
            for(int[] edge: paths) {
                int u = Math.min(edge[0], edge[1]);
                int v = Math.max(edge[0], edge[1]);
                if (result[u - 1] == result[v - 1]) {
                    stop = false;
                    result[v - 1] = result[v - 1] == 4 ? 1 : result[v - 1] + 1;
                }
            }
        }
        while(!stop);
        return result;
    }
}
