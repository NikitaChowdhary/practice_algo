package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class ValidParanethesisAdd {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        int result = 0, temp = 0;
        for (int i = 0; i< S.length(); i++) {
            temp += (S.charAt(i) == '(') ? 1: -1;
            if (temp == -1) {
                temp = 0;
                result++;
            }

        }
        return result + temp;

    }


    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     * @param S
     * @return
     */
    public int minAddToMakeValid1(String S) {
        Stack<Character> paranthesisStack = new Stack<>();
        int result = 0;
        for (int i = 0; i< S.length(); i++) {
            if (S.charAt(i) == '(')
                paranthesisStack.add('(');
            else if (S.charAt(i) == ')') {
                if (paranthesisStack.size() > 0)
                    paranthesisStack.pop();
                else result++;
            }

        }
        result += paranthesisStack.size();
        return result;

    }
}
