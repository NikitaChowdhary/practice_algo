package common;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        else
            return false;
    }
}
