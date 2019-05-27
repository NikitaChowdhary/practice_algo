package leetCode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        setLCA(root, p, q);
        return result;
    }

    private boolean setLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        int left = setLCA(root.left, p, q) ? 1 : 0;
        int right = setLCA(root.right, p, q) ? 1 : 0;

        int current = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if (left + right + current >=2) result = root;

        return (left + right + current > 0);
    }
}
