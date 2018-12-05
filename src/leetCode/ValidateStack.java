package leetCode;

import java.util.Stack;

// https://leetcode.com/contest/weekly-contest-112/problems/validate-stack-sequences/
/*
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 */
public class ValidateStack {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int x: pushed) {
            stack.push(x);
            while(!stack.isEmpty() && j < pushed.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;

    }

    public static void main(String[] args) {
        int[] push = new int[] {1,2,3,4,5};
        int[] pop = new int[] {4,5,3,2,1};
        int[] pop2 = new int[] {4,5,3,1,2};

        System.out.println(new ValidateStack().validateStackSequences(push, pop2));
    }
}
