package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
public class ValidParanthesis {

    public boolean isValid(String s) {

        Map<Character, Character> validClose = new HashMap<>();
        validClose.put('}', '{');
        validClose.put(')', '(');
        validClose.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (!stack.isEmpty() && stack.pop() != validClose.get(ch))
                    return false;
            }
        }
        return stack.isEmpty();

    }
}
