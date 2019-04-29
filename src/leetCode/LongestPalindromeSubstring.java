package leetCode;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeSubstring {
    static Result result = new Result(0, 0 );

    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length() + 1][s.length()];

        for (int i = 0; i<s.length(); i++) {
            dp[1][i] = 1;
            updateResult(dp, i, 1);
        }

        for (int i = 2; i<= s.length(); i++) {
            for (int j = 0; (j + i) <= s.length(); j++) {
                if (s.charAt(j) == s.charAt(i + j - 1) && dp[i-2][j+1] == i - 2) {
                    dp[i][j] = dp[i - 2][j + 1] + 2;
                    updateResult(dp, j, dp[i - 2][j + 1] + 2);
                }
            }
        }

        System.out.println(result.max);
        if (s.isEmpty())
            return "";
        return s.substring(result.pos_j, result.pos_j + result.max);
    }

    private static void updateResult(int[][] dp, int j, int max) {

        if (result.max < max)
            result = new Result(max, j);
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
