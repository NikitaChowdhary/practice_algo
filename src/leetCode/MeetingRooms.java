package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/meeting-rooms/
 *
 * Sorting O(n * log n)
 * Computation O(n)
 *
 * Space complexity - O(1)
 */
public class MeetingRooms {


    Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] == o2[0]) return 0;
            else return 1;
        }
    };

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, comp);
        int end = Integer.MIN_VALUE;
        for (int[] range: intervals) {
            if (range[0] < end) // Overlapping
                return false;
            else
                end = range[1];
        }
        return true;
    }
}
