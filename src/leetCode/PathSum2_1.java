package leetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class PathSum2_1 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      getPaths(root, new ArrayList<>(), sum);
      return result;
  }

    private void getPaths(TreeNode root, List<Integer> path, int sum) {
      if (root == null) return;

      path.add(root.val);
      if (root.left == null && root.right == null && sum == root.val)
          result.add(path);
      else {
          getPaths(root.left, path, sum - root.val);
          getPaths(root.right, path, sum - root.val);
      }
      path.remove(path.size() - 1);

      }
}
