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
public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();

        System.out.println(getLCS(a, b ,0, 0));
    }

    private static int getLCS(String a, String b, int start_a, int start_b) {
        if (a.isEmpty() || b.isEmpty()) return 0;

        if (start_a == a.length() || start_b == b.length()) return 0;

        if (a.charAt(start_a) == b.charAt(start_b))
            return 1 + getLCS(a, b, start_a + 1, start_b + 1);
        else
            return Math.max(
                    getLCS(a, b, start_a + 1, start_b),
                    getLCS(a, b, start_a, start_b + 1)
            );
    }
}
