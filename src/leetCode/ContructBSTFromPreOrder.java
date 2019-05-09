package leetCode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */

public class ContructBSTFromPreOrder {

    public TreeNode bstFromPreorder(int[] preorder) {
        return getBST(preorder, 0, preorder.length - 1);

    }

    private TreeNode getBST(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);

        int pos = start + 1;
        while(pos < preorder.length && preorder[pos] < preorder[start]) {
            pos++;
        }
        root.left = getBST(preorder, start + 1, pos);
        root.right = getBST(preorder, pos + 1, end);
        return root;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
