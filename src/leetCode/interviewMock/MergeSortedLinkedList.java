package leetCode.interviewMock;

public class MergeSortedLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = l1;

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        if (l1 != null && l2 != null) {

            while(currentL1 != null && currentL2 != null) {
                if (currentL1.val < currentL2.val) {currentL1 = currentL1.next;}
                else {
                    ListNode temp = currentL1.next;
                    currentL1.next = currentL2;

                    int l1val = currentL1.val;
                    currentL1.val = currentL2.val;
                    currentL2.val = l1val;


                    currentL2 = currentL2.next;
                    currentL1.next.next = temp;
                    currentL1 = currentL1.next;
                }
            }
        }

        if (currentL2 != null) {
            currentL1 = result;
            while(currentL1 != null && currentL1.next != null)
                currentL1 = currentL1.next;
            currentL1.next = currentL2;
        }

        return result;
    }
}
