package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 *
 */
public class RomanToInteger {


    public static int romanToInt(String s) {

        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);


        int result = 0;
        char previous = 'a';
        for (int i = s.length() - 1; i>=0; i--  ) {
            char current = s.charAt(i);
            int currentVal = romans.get(current);

            int previousVal = romans.getOrDefault(previous, 0);
            if ((currentVal == 1 || currentVal == 10 || currentVal == 100) && (previousVal == currentVal * 5 || previousVal == currentVal * 10))
                result -= currentVal;
            else
            result += romans.get(current);
            previous = current;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.printf("result " + romanToInt("MCMXCIV"));

    }
}
