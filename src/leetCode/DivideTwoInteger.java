package leetCode;

/**
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoInteger {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int multiplier = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        int ans = 0;
        while (dividend <= divisor) {
            int bitCount = 0;

            for (int div = divisor; dividend <= div && div < 0; div <<= 1) {
                dividend -= div;
                ++bitCount;
            }

            ans += (1 << bitCount) - 1;
        }

        /**
         * TLE with this logic
         * O(dividend)
         *
        while (dividend <= divisor)
        {
            dividend -= divisor;
            ++ans;
        }
         **/

        return ans * multiplier;
    }

    public static void main(String[] args) {
        System.out.println(divide(20,
                6));
    }
}
