package GFGeek;

public class TreetoDLL {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode succ;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.succ = null;
        }
    }
    TreeNode previous, head = null;
    public void tree2DLL(TreeNode root) {
        if (root != null) {
            tree2DLL(root.left);

            if (previous == null)
                head = root;
            else {
                previous.right = root;
                root.left = previous;
            }
            previous = root;


            tree2DLL(root.right);
        }
    }
}
