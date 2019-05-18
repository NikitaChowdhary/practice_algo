package leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/solution/
 */
public class FirstUniqueChar {

    /**
     * Using HashMap does not keep the keys in order of insertion,
     * which means we need to check all the characters in the map which have value 1
     * and then find minimum. Which overall increases the timecomplexity in worst case
     * where all characters are unique, but the hashmap stored in reverse order and now
     * fetching index of each character is O(n * 1) * 26
     *
     *
     * @param s
     * @return
     */
    public static int firstUniqChar1(String s) {

        Map<Character, Integer> charac = new HashMap<>();

        for (int i = 0; i< s.length(); i++) {
            int current = charac.getOrDefault(s.charAt(i), 0) + 1;
            charac.put(s.charAt(i), current);
        }
        int minIndex = Integer.MAX_VALUE;
        for (char i : charac.keySet()) {
            if (charac.get(i) == 1)
                minIndex = Math.min(minIndex, s.indexOf(i));
        }
        return (minIndex == Integer.MAX_VALUE) ? -1 : minIndex;
    }

    /**
     * Use LinkedHashMap instead, which has same performance of HashMap and it keeps the order of insertion
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        Map<Character, Integer> charac = new LinkedHashMap<>();

        for (int i = 0; i< s.length(); i++) {
            int current = charac.getOrDefault(s.charAt(i), 0) + 1;
            charac.put(s.charAt(i), current);
        }
        for (char i : charac.keySet()) {
            if (charac.get(i) == 1)
                return s.indexOf(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
