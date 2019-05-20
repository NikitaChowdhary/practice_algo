package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesOfBinary {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        else {
            List<List<Integer>> left = findLeaves(root.left);
            List<List<Integer>> right = findLeaves(root.right);
            result = merge(left, right);
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
        }
        return result;
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        for (; i < Math.min(left.size(), right.size()); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(left.get(i));
            temp.addAll(right.get(i));
            res.add(temp);
        }

        if (left.size() > i) {
            for (; i< left.size(); i++)
                res.add(left.get(i));
        }

        else if (right.size() > i) {
            for (; i< res.size(); i++)
                res.add(right.get(i));
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
