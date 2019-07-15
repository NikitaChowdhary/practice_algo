package leetCode;

// https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() ^ p.isEmpty()) return false;
        else {
            int pi = 0, si = 0;
            while(pi < p.length() && si < s.length()) {
                if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                    while(si < s.length() && s.charAt(si) == p.charAt(pi))
                        si++;
                    pi += 2;
                } else if (p.charAt(pi) == '.') {
                    pi++;
                    si++;
                } else {
                    if (p.charAt(pi) != s.charAt(si)) return false;
                    pi++;
                    si++;
                }
            }
            return  (pi == p.length() && si == s.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }
}
