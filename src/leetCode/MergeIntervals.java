package leetCode;

import java.util.*;

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start< o2.start) return -1;
                else if (o1.start == o2.start) return 0;
                else return 1;
            }
        };
        Collections.sort(intervals, comp);
        if (intervals.isEmpty()) return result;
        else {
            int index = 0;
            result.add(index, intervals.get(index));
            for (int i = 1; i< intervals.size(); i++) {
                Interval current = result.get(index);
                // Overlapping
                if (current.end >= intervals.get(i).start) {
                    result.remove(index);
                    result.add(index, new Interval(current.start, Math.max(intervals.get(i).end, current.end)));
                } else {
                    index++;
                    result.add(index, intervals.get(i));
                }
            }

        }
        return result;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        List<Interval> input = Arrays.asList(new Interval(1,3),new Interval(2,6),new Interval(8,10),new Interval(15,18));
        List<Interval> res = merge(input);
        for (Interval i: res) {
            System.out.println(i.start + " " +i.end);
        }
    }
}
