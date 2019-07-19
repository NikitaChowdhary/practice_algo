package leetCode.interviewMock;

/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 */
public class StringGCD {
    public String gcdOfStrings(String str1, String str2) {


        int gcd = getGCD(str1.length(), str2.length());

        String result = "";
        if (str1.substring(0, gcd).equals(str2.substring(0, gcd)))
            result = str1.substring(0, gcd);

        return result;
    }

    private int getGCD(int l1, int l2) {
        if (l2 == 0) return l1;
        else return getGCD(l2, l1 % l2);
    }
}
