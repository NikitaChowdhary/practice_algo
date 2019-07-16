package leetCode.interviews;

/**
 * Given the root of a binary tree, consider all root to leaf paths: paths from the root to any leaf.  (A leaf is a node with no children.)
 *
 * A node is insufficient if every such root to leaf path intersecting this node has sum strictly less than limit.
 *
 * Delete all insufficient nodes simultaneously, and return the root of the resulting binary tree.
 */
public class InsufficientNodes {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode sufficientSubset(TreeNode root, int limit) {

        TreeNode parent = null;
        updateTree(root, limit, 0, parent);
        return root;
    }

    private boolean updateTree(TreeNode root, int limit, int currentSum, TreeNode parent) {
        if (root != null) {
            int sum = currentSum + root.val;
            boolean isLeaf = (root.left == null && root.right == null);
            boolean leftDeleted = updateTree(root.left, limit, sum, root);
            boolean rightDeleted = updateTree(root.right, limit, sum, root);

            if (isLeaf && sum < limit) {
                deleteNode(root, parent);
                return true;
            }
            else if ((root.right == null && leftDeleted) || (root.left == null && rightDeleted) || leftDeleted && rightDeleted) {
                deleteNode(root, parent);
                return true;
            } else return  false;
        }
        else return false;
    }

    private void deleteNode(TreeNode root, TreeNode parent) {
        if (parent != null) {
            if (parent.left == root) parent.left = null;
            else if (parent.right == root) parent.right = null;
        }
    }
}
