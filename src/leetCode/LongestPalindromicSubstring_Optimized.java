package leetCode;

/**
 *
 * https://leetcode.com/problems/longest-palindromic-substring/
 * O(n^2) time complexity
 * O(1) space complexity
 **/

public class LongestPalindromicSubstring_Optimized {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;

        for (int i = 0 ; i < s.length(); i++) {
            int ind1 = expandAroundCenter(s, i, i);
            int ind2 = expandAroundCenter(s, i, i + 1);

            int ind = Math.max(ind1, ind2);
            if (ind > end - start) {
                start = i - (ind - 1)/2;
                end = i + ind/2;
            }
        }

        return s.substring(start, end + 1);

    }

    private static int expandAroundCenter(String s, int i, int i1) {
        int l = i;
        int r = i1;

        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
    }
}
