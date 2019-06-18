package leetCode;

import java.util.*;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortByFrequency {
    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            int currentCount = map.getOrDefault(c, 0) + 1;
            map.put(c, currentCount);
        }

        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.count <= o2.count) return 1;
                else return -1;
            }
        };
        SortedSet<Pair> sortedSet = new TreeSet<>(comp);
        for (char c: map.keySet()) {
            sortedSet.add(new Pair(c, map.get(c)));
        }

        StringBuilder res = new StringBuilder();
        for (Pair a: sortedSet) {
            for (int i = 0; i< a.count; i++) {
                res.append(a.ch);
            }
        }
        return res.toString();
    }
    static class Pair {
        char ch;
        int count;
        Pair(char c, int count) {
            this.ch = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
