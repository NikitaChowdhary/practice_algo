package leetCode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time complexity - O(n)
 * Space complexity - O(1) - fixed length as 26 character.
 * If it has special characters then it might be more, but still a fixed length.
 */
public class LongestSubstringOfRepeatingChar {

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0, currentStartPos = 0;
        HashMap<Character, Integer> charPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!charPos.containsKey(current) || charPos.get(current) < currentStartPos) { // start index of this unique string does not include something commong
                int len = i - currentStartPos + 1;
                maxLength = Math.max(maxLength, len);
            } else
                currentStartPos = charPos.get(current) + 1;
            charPos.put(current, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
