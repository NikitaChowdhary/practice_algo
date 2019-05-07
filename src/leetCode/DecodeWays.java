package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 */

public class DecodeWays {

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return getDecodings(s, 0, dp);

    }

    private static int getDecodings(String s, int pos, int[] dp) {
        if (dp[pos] != -1) return dp[pos];
        if (pos > s.length()) return 0;
        if (pos == s.length()) return 1;

        int singleDigit = 0, doubleDigit = 0;
        if (s.charAt(pos) != '0') {
            singleDigit = getDecodings(s, pos + 1, dp);
            if (pos + 2 <= s.length()) {
                int number = Integer.parseInt(s.substring(pos, pos + 2));
                if (number > 0 && number <=26)
                    doubleDigit = getDecodings(s, pos + 2, dp);
            }
        }
        dp[pos] = singleDigit + doubleDigit;
        return dp[pos];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("10120"));
    }
}
