package leetCode;


import java.util.*;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * O(n log(n))
 *
 * log n for inserting a value in TreeMap
 * TreeMap O(logn) -- since the underlying structure is a red-black tree.
 *
 *
 *  NO IDEA WHY I USED SORTEDMAP HERE, I HAD MAX HEAP IN MIND WHICH SHOULD HAVE BEEN PRIORITY QUEUE
 */


public class KClosestPoint {

    public static int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        if (K > points.length) return result;

        SortedMap<Integer, List<Integer>> temp= new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i< K; i++) {
            int eucDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            List<Integer> ind = temp.getOrDefault(eucDist, new ArrayList<>());
            ind.add(i);
            temp.put(eucDist, ind);
        }

        for (int i = K; i < points.length; i++) {
            int eucDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int headKey = temp.firstKey();
            if (headKey > eucDist) {
                if (temp.get(headKey).size() == 1)
                    temp.remove(headKey);
                else {
                    List<Integer> ind = temp.get(headKey);
                    ind.remove(0);
                    temp.put(headKey, ind);
                }
                List<Integer> ind = temp.getOrDefault(eucDist, new ArrayList<>());
                ind.add(i);
                temp.put(eucDist, ind);
            }
        }

        List<List<Integer>> index = new ArrayList<>(temp.values());
        List<Integer> finalIndex = new ArrayList<>();
        for (int i = 0; i< index.size(); i++)
            finalIndex.addAll(index.get(i));

        for (int i = 0; i< finalIndex.size(); i++) {
            result[i][0] = points[finalIndex.get(i)][0];
            result[i][1] = points[finalIndex.get(i)][1];
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] point1 = {{1, 3}, {-2, 2}};
        int[][] result = kClosest(point1, 1);

        for (int i = 0; i< result.length; i++)
            System.out.println("[ " + result[i][0] + ", " + result[i][1] + " ]");
    }
}
