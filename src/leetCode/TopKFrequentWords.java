package leetCode;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count < o2.count) return -1;
                else if (o1.count == o2.count) return -1 * o1.word.compareTo(o2.word);
                else return  1;
            }
        });

        for (String word: words) {
            int currentCount = map.getOrDefault(word, 0) + 1;
            map.put(word, currentCount);
        }

        for (String key: map.keySet()) {
            queue.add(new Pair(key, map.get(key)));
            if (queue.size() > k) queue.poll();
        }
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            String current = queue.poll().word;
            result.add(current);
        }
        Collections.reverse(result);
        return result;
    }

    static class Pair {
        String word;
        int count;
        Pair(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    public static void main(String[] args) {
        String[] inp = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(inp, 2));
    }
}
