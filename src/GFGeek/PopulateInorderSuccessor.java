package GFGeek;

public class PopulateInorderSuccessor {

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

        public void populateValue(TreeNode root) {
            TreeNode next = null;

            populateUtil(root, next);
        }

        private void populateUtil(TreeNode root, TreeNode next) {
            if (root != null) {
                populateUtil(root.right, next);

                root.succ = next;
                next = root;

                populateUtil(root.left, next);
            }
        }
    }
}
