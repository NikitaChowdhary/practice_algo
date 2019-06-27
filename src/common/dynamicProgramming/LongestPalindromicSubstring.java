package common.dynamicProgramming;

public class LongestPalindromicSubstring {

    int longestPalSubstr(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];

        int maxLength = 1;

        for (int i = 0; i< str.length(); i++)
            dp[i][i] = true;

        for (int i = 0; i < str.length() -1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        for (int len = 3; len <=str.length(); len++) {
            for (int start = 0; start < str.length() - len + 1; start++) {
                int end = start + len - 1;

                if (dp[start + 1][end - 1] && str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = true;
                    if (len > maxLength) {
                        start = len;
                        maxLength = len;
                    }
                }
            }
        }

        return maxLength;
    }
}
