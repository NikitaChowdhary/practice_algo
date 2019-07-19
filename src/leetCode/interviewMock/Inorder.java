package leetCode.interviewMock;

public class Inorder {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    TreeNode result = new TreeNode(Integer.MAX_VALUE);
    boolean found = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        getInorder(root, p);
        if (result.val == Integer.MAX_VALUE) result = null;
        return result;

    }

    private void getInorder(TreeNode root, TreeNode p) {
        if (root!= null) {
            getInorder(root.right, p);

            if (p.val == root.val) {
                found = true;
                return;
            }
            if (!found) {
                result = root;
                getInorder(root.left, p);
            }
        }
    }
}
