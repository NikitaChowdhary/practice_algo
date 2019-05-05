package leetCode;

/**
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 * O(n^2) time complexity
 * O(n^2) space complexity
 **/


public class LongestPalindromeSubstring {
    static Result result = new Result(0, 0 );

    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length() + 1][s.length()];
        String maxString = "";

        for (int i = 0; i<s.length(); i++) {
            dp[1][i] = 1;
            if (maxString.length() < s.substring(i, i + 1).length())
                maxString = s.substring(i, i + 1);
            if (result.max < 1)
                result = new Result(1, i);
        }

        for (int i = 2; i<= s.length(); i++) {
            for (int j = 0; (j + i) <= s.length(); j++) {
                if (s.charAt(j) == s.charAt(i + j - 1) && dp[i-2][j+1] == i - 2) {
                    dp[i][j] = dp[i - 2][j + 1] + 2;
                    if (result.max < dp[i][j])
                        result = new Result(dp[i][j], j);
                }
            }
        }

        System.out.println(result.max);
        if (s.isEmpty())
            return "";
        return s.substring(result.pos_j, result.pos_j + result.max);
    }

    static class Result {
        int max;
        int pos_j;
        Result(int max, int j) {
            this.max = max;
            // start position of palindrome string
            this.pos_j = j;
        }

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
    }


}
