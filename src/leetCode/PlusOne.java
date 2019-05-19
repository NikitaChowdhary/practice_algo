package leetCode;


/**
 * https://leetcode.com/problems/plus-one/submissions/
 *
 * Time Complexity - O(n)
 *
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int remainder = 1;
        for (int i = digits.length - 1; i>=0; i--) {
            int current = digits[i] + remainder;
            digits[i] = current % 10;
            remainder = current / 10;
        }
        if (remainder > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = remainder;
            for (int i = 1; i< result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
