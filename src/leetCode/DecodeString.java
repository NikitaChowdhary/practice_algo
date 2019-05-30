package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> integers = new Stack<>();
        Stack<String> strings = new Stack<>();
        int currentNumber = 0;
        StringBuilder currentString = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c))
                currentNumber = c - '0' + 10 * currentNumber;
            else if (c == '[') {
                integers.push(currentNumber);
                currentNumber = 0;
                strings.push(currentString.toString());
                currentString = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder temp = new
                        StringBuilder(strings.pop());
                int repeatTimes = integers.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = temp;

            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();

    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
