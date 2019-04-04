package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class SumLinkedLIst {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode finalRes = null;
        int carry = 0;
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            while(l1 != null && l2 != null) {
                int temp = l1.val + l2.val + carry;
                if (result == null) {
                    result = new ListNode(temp % 10);
                    finalRes = result;
                }
                else {
                    ListNode tempNode = new ListNode(temp%10);
                    result.next = tempNode;
                    result = result.next;
                }
                carry = temp / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1.next != null) {
                int temp = carry + l1.val;
                result.next = new ListNode(temp%10);
                carry = temp / 10;
                l1 = l1.next;
                result = result.next;
            }

            while(l2.next != null) {
                int temp = carry + l2.val;
                result.next = new ListNode(temp%10);
                carry = temp / 10;
                l2 = l2.next;
                result = result.next;
            }
            return finalRes;
        }

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode i1 = new ListNode(2);
        i1.next = new ListNode(4);
        i1.next.next = new ListNode(3);

        ListNode i2 = new ListNode(5);
        i2.next = new ListNode(6);
        i2.next.next = new ListNode(4);
        System.out.println(addTwoNumbers(i1, i2));
    }

}
