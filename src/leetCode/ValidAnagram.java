package leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Time - O(n) n is length of string
 *
 * Space - O(1) as there is 26 alphabets
 *
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char c: s.toCharArray()) {
            int count = characterCount.getOrDefault(c, 0);
            count++;
            characterCount.put(c, count);
        }

        for (char c: t.toCharArray()) {
            if (!characterCount.containsKey(c))
                return false;
            else {
                int count = characterCount.get(c);
                count--;
                if (count == 0)
                    characterCount.remove(c);
                else
                    characterCount.put(c, count);
            }
        }

        return (characterCount.size() == 0);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
