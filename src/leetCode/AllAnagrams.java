package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class AllAnagrams {

    public static void main(String[] args) {
        Solution obj = new Solution();
        for (int i: obj.findAnagrams("cbaebabacd", "abc"))
            System.out.println(i);
    }

    public static class Solution {

        public List<Integer> findAnagrams(String s, String p) {

            List<Integer> result = new ArrayList<>();
            if (s.length() >= p.length()) {
                int size = p.length();
                for (int i = 0; i <= s.length() - size; i++) {
                    if (isAnagram(s.substring(i, i + size), p))
                        result.add(i);
                }
            }
            return result;
        }

        private boolean isAnagram(String source, String target) {

            int[] characters = new int[256];
            for (int i = 0; i< source.length(); i++) {
                characters[source.charAt(i)]++;
                characters[target.charAt(i)]--;
            }

            for (int val: characters) {
                if (val != 0) return false;
            }
            return true;
        }


    }
}

