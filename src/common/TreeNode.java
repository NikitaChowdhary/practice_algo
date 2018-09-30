package common;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;
        else
            return false;
    }
}
