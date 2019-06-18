package leetCode;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count < o2.count) return 1;
                else if (o1.count == o2.count) return 0;
                else return -1;
            }
        });

        for (int num: nums) {
            int currentCount = map.getOrDefault(num, 0) + 1;
            map.put(num, currentCount);
        }

        int i = 0;
        for (int key: map.keySet()) {
            queue.add(new Pair(key, map.get(key)));
        }
        List<Integer> result = new ArrayList<>();
        for (; i < k && !queue.isEmpty(); i++) {
            int current = queue.poll().num;
            result.add(current);
        }
       return result;
    }

    static class Pair {
        int num;
        int count;
        Pair(int num, int count) {
            this.count = count;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        int[] inp = {1,1,1,2,2,3};
        System.out.println(topKFrequent(inp, 2));
    }

}
