package leetCode;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */

class CountNode {

    /**
     *
     * @param root
     * @return
     */

    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight - 1 == rightHeight) {
            return (int)Math.pow(2, leftHeight - 2) + countNodes(root.left);
        } else
            return (int)Math.pow(2, leftHeight - 1) + countNodes(root.right);
    }

    private int getRightHeight(TreeNode root) {
        if (root == null) return 0;
        int height = 1;
        if (root.right != null) {
            root = root.right;
            height++;
        }
        else return height;
        while(root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    public int getLeftHeight(TreeNode root) {
        if (root == null) return 0;
        else return 1 + getLeftHeight(root.left);
    }


// ------------------------------------------------------------------------------------------------------
    /**
     * Leet code logic to parse input
     * @return
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[1, 2, 3, 4, 5, 6]";
//        while (line!= null) {

            TreeNode root = stringToTreeNode(line);

            int ret = new CountNode().countNodes(root);

            String out = String.valueOf(ret);

            System.out.print(out);
//        }
    }
}
