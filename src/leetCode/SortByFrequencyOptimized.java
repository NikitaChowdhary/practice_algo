package leetCode;

import java.util.*;

public class SortByFrequencyOptimized {
    public static String frequencySort(String s) {
        int[] characters = new int[256];

        for (char c: s.toCharArray())
            characters[c]++;

        List<List<Character>> sortedList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) sortedList.add(new ArrayList<>());
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != 0) {
                sortedList.get(characters[i] - 1).add((char)i);
            }
        }


        StringBuilder res = new StringBuilder();
        for (int i = sortedList.size() - 1; i>=0; i--) {
            if (sortedList.get(i).size() > 0) {
                for (char current: sortedList.get(i)) {
                    int temp = i + 1;
                    while (temp-- > 0)
                        res.append(current);
                }
            }
        }


        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
