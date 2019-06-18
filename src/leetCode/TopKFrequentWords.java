package leetCode;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) - map.get(w2) );

        for (String word: words) {
            int currentCount = map.getOrDefault(word, 0) + 1;
            map.put(word, currentCount);
        }

        for (String key: map.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] inp = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(inp, 1));
    }
}
