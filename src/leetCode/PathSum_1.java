package leetCode;

// https://leetcode.com/problems/path-sum/
public class PathSum_1 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        else {
            if (root.left == null && root.right == null && sum == root.val) return true;

            else {
                boolean left = hasPathSum(root.left, sum - root.val);
                boolean right = hasPathSum(root.right, sum - root.val);
                return left || right;
            }
        }
    }
}
