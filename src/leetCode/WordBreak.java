package leetCode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /**
     *
     * https://leetcode.com/problems/word-break/
     * Dp -> O(size(s) * length of dict)
     * */


    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // Empty string matches the word dictionary
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {

            if (!dp[i]) continue;

            for (String word: wordDict) {
                int end = i + word.length();
                if (s.length() >= end && s.substring(i, end).equals(word)) dp[end] = true;

            }
        }


        return dp[s.length()];

    }


    public static boolean optimizedWordBreak(String s, List<String> wordDict) {
        int[] pos = new int[s.length() + 1];
        Arrays.fill(pos, -1);

        pos[0] = 0;
        for (int i = 0; i< s.length(); i++) {
            if (pos[i] != -1) {
                for (int j = i + 1; j<=s.length(); j++) {
                    String temp = s.substring(i, j);
                    if (wordDict.contains(temp))
                        pos[j] = i;
                }
            }
        }


        return pos[s.length()] != -1;
    }

    public static void main(String[] args) {
        String ip1 = "catsanddog";
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(optimizedWordBreak(ip1, dict));
    }
}
