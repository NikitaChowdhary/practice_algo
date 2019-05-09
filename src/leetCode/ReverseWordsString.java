package leetCode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsString {

    public static String reverseWords(String s) {
        if (s == null) return "";
        s = s.trim();
        int start = -1;
        s = s.replaceAll("( )+", " ");

        char[] str = s.toCharArray();
        for (int i = 0; i< str.length; i++){
            if (str[i]!= ' ') continue;
            reverseStringInplace(str, start + 1, i - 1);
            start = i;
        }
        reverseStringInplace(str, start + 1, s.length() - 1);
        reverseStringInplace(str, 0, str.length - 1);
        return String.valueOf(str);
    }

    private static void reverseStringInplace(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
