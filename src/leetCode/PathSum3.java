package leetCode;

// https://leetcode.com/problems/path-sum-iii/
public class PathSum3 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        else return hasPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int hasPath(TreeNode root, int sum) {
        if (root == null) return 0;
        else {
            int val = (sum == root.val) ? 1: 0;
            return val + hasPath(root.left, sum - root.val) + hasPath(root.right, sum - root.val);
        }
    }
}
