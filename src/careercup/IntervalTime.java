package careercup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.careercup.com/question?id=5687609083297792
 *
 * Given a list of arrays of time intervals, write a function that calculates the total amount of time covered by the intervals.
 * For example:
 * input = [(1,4), (2,3)]
 * return 3
 * input = [(4,6), (1,2)]
 * return 3
 * input = {{1,4}, {6,8}, {2,4}, {7,9}, {10, 15}}
 * return 11
 *
 * Time complexity -> O(n * log n)
 * Space complexity -> O(1)
 *
 */

public class IntervalTime {

    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(6, 8));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(7, 9));
        intervals.add(new Interval(10, 15));


        System.out.println(getTotalTimeCovered(intervals));

    }

    private static int getTotalTimeCovered(List<Interval> intervals) {

        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                else if (o1.start == o2.start) return 0;
                else return 1;
            }
        };
        Collections.sort(intervals, comp);

        int time = 0, start = -1, end = -1;

        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (current.start < end) {
                // Overlapping intervals
                end = Math.max(end, current.end);
            } else {
                time += end - start;
                start = current.start;
                end = current.end;
            }
        }

        return time + (end - start);
    }

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
