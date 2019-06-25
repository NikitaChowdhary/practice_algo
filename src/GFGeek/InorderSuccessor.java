package GFGeek;

public class InorderSuccessor {
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
    TreeNode root;

    public void getInorder(TreeNode node) {
        TreeNode succ = null;

        getInorderUtil(node, succ, root);
    }

    private void getInorderUtil(TreeNode node, TreeNode succ, TreeNode root) {

        if (root != null) {
            getInorderUtil(node, succ, root.right);

            if (root.val == node.val) {
                System.out.println(succ.val);
            }
            succ = root;

            getInorderUtil(node, succ, root.left);
        }
    }
}
