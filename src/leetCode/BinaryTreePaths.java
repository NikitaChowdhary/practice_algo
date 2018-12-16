package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    // https://leetcode.com/problems/binary-tree-paths/


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }



    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)  return new LinkedList<>();
        else {
            List<String> result = new LinkedList<>();
            getPath(root, result, "");
            return result;
        }
    }



    public void getPath(TreeNode root, List<String> result, String path) {
        if (root == null) return;

        String update;
        if (path.isEmpty()) update = "" + root.val;
        else {
            update = path + "->" + root.val;
        }

        // If is leaf add to result
        if (root.left == null && root.right == null) {
            result.add(update);
        }

        getPath(root.left, result, update);
        getPath(root.right, result, update);
    }




    // ***************************************************************************************************
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<String> ret = new BinaryTreePaths().binaryTreePaths(root);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
