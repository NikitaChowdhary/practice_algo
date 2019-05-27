package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * O(n log n) -> Sorting
 * O(log n ) -> MinHeap
 *
 * Overall -> O(n log n)
 *
 * Space -> O(n) Size of min heap
 *
 */
public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(intervals, comp);

        PriorityQueue<Integer> roomsEndTime = new PriorityQueue<>();
        for (int[] range: intervals) {
            if (roomsEndTime.size() > 0 && roomsEndTime.peek() <= range[0])
                roomsEndTime.poll();

            roomsEndTime.add(range[1]);
        }
        return roomsEndTime.size();

    }

    public static void main(String[] args) {
        int[][] inp = {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}};
        System.out.println(minMeetingRooms(inp));
    }
}
