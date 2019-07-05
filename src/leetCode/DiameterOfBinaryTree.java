package leetCode;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getDiam(root);
        return diameter - 1;
    }

    public int getDiam(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDiam(root.left);
        int rightDepth = getDiam(root.right);

        diameter = Math.max(diameter, leftDepth + rightDepth + 1);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
