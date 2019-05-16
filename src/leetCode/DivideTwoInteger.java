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

            // Not sure what this does and how it works
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


    /**
     * \As every number can be represented in base 2(0 or 1), represent the quotient in binary form by using shift operator as given below :
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide1(int dividend, int divisor) {
        boolean multiplier = (dividend < 0) ^ (divisor < 0); // false if both same signs
        long absdividend = Math.abs((long)dividend);
        long absdivisor =  Math.abs((long)divisor);
        long temp = 0, quotient = 0;
        for (int i = 31; i >= 0; --i) {

            long val = absdivisor << i;
            if (temp + val <= absdividend) {
                temp += val;
                quotient |= 1L << i;
            }
        }

        long result = (multiplier) ? Math.max(-1 * quotient, Integer.MIN_VALUE) : Math.min(quotient, Integer.MAX_VALUE);

        return (int) result;

    }

    public static void main(String[] args) {
        System.out.println(divide1(10, 3));
    }
}
