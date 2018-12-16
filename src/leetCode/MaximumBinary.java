package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumBinary {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        return generateTree(start, end, nums);
    }


    public TreeNode generateTree(int start, int end, int[] nums) {
        if (start > end) return null;
        else {
            int indexOfMax = getMax(start, end, nums);
            TreeNode root = new TreeNode(nums[indexOfMax]);
            root.left = generateTree( start, indexOfMax - 1, nums);
            root.right= generateTree(indexOfMax + 1, end, nums);
            return root;
        }
    }

    public int getMax(int start, int end, int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i<=end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    // *********************************************************************************************************

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            TreeNode ret = new MaximumBinary().constructMaximumBinaryTree(nums);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }


}
