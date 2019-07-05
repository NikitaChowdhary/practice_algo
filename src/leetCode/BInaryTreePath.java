package leetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/
public class BInaryTreePath {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String>  result = new ArrayList<>();
        addPathToResult(root, result, "");
        return result;
    }

    private void addPathToResult(TreeNode root, List<String> result, String path) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null)
                result.add(path);
            else {
                path += "->";
                addPathToResult(root.left, result, path);
                addPathToResult(root.right, result, path);
            }

        }
    }

}
