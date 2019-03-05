package common.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 */
public class LCSArray {
    static int lcs = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();

        System.out.println(getLCS(a, b));
    }

    // dp[i][j] is lcs ending at i, j dp[0][0] = 0;
    private static int getLCS(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        if (word1.isEmpty() || word2.isEmpty()) return 0;

        for (int i = 0; i<= word1.length(); i++) {
            for (int j = 0; j <=word2.length(); j++) {

                if (i == 0 || j == 0) dp[i][j] = 0;

                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
