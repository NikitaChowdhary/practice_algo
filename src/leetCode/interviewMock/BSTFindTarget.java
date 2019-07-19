package leetCode.interviewMock;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class BSTFindTarget {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    Map<Integer, Integer> map = new HashMap();
    public boolean findTarget(TreeNode root, int k) {
        traverse(root);


        for (int a: map.keySet()) {
            int remaining = k - a;
            if (map.containsKey(remaining) && remaining != a)
                return true;
        }
        return false;
    }

    private void traverse(TreeNode root) {
        if (root != null) {
            map.put(root.val, 1);
            traverse(root.right);
            traverse(root.left);
        }
    }
}
