package leetCode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 */
public class StringtoInteger {

    public static int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        str = str.trim();
        int multiplier = 1;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            multiplier = (str.charAt(0) == '-') ? -1 : 1;
            str = str.substring(1);
        }

        boolean isOverflow = false;
        long result = 0;
        for (int i = 0; i< str.length(); i++) {
            if (!(str.charAt(i) >= '0') || !(str.charAt(i) <= '9'))
                break;
            else {
                long temp = result* 10 + str.charAt(i) - '0';
                if (temp > Integer.MAX_VALUE) {
                    isOverflow = true;
                    break;
                }
                result = temp;

            }
        }
        if (isOverflow){
            result = Integer.MAX_VALUE;
            if (multiplier == -1)
                result = Integer.MIN_VALUE;
        }
        else result = result * multiplier;

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-6147483648"));
    }
}
