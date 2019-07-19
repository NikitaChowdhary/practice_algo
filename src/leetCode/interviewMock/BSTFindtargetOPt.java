package leetCode.interviewMock;

import java.util.ArrayList;
import java.util.List;


public class BSTFindtargetOPt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> inorder = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        getInorder(root);

        int start = 0, end = inorder.size() - 1;
        while(start < end) {
            if (k - inorder.get(start) == inorder.get(end)) return true;
            else if (k - inorder.get(start) < inorder.get(end)) end--;
            else start++;
        }
        return false;
    }

    private void getInorder(TreeNode root) {
        if (root != null){
            getInorder(root.left);
            inorder.add(root.val);
            getInorder(root.right);

        }
    }

}
