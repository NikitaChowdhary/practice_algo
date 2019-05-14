package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * O(n log(n))
 *
 * log n for inserting/deleting a value in Priority Queue
 *
 */
public class KClosestPoint_Cleaner {

    public static int[][] kClosest(int[][] points, int K) {

        int[][] result = new int[K][2];

        Comparator<Points> comparator = new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                if (o1.distance < o2.distance) return 1;
                else if (o1.distance == o2.distance) return 0;
                else return -1;
            }
        };

        PriorityQueue<Points> priorityQueue = new PriorityQueue<>(comparator);

        for (int[] po: points)
            priorityQueue.add(new Points(po[0], po[1]));

        while(priorityQueue.size() > K)
            priorityQueue.poll();

        int i = 0;
        while(!priorityQueue.isEmpty()) {
            Points current = priorityQueue.poll();
            result[i][0] = current.x;
            result[i][1] = current.y;
            i++;
        }
        return result;
    }

    public static class Points {
        int x,y, distance;
        Points(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }
    }


    public static void main(String[] args) {
        int[][] point1 = {{1, 3}, {-2, 2}};
        int[][] result = kClosest(point1, 1);

        for (int i = 0; i< result.length; i++)
            System.out.println("[ " + result[i][0] + ", " + result[i][1] + " ]");
    }
}
