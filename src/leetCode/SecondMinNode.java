package leetCode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class SecondMinNode {
    int firstMin;
    long min = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        else {
            firstMin = root.val;
            getMin(root);
            return (min < Long.MAX_VALUE) ? (int)min: -1;

        }
    }

    private void getMin(TreeNode node) {
        if (node != null) {
            if (firstMin < node.val && node.val < min) {
                min = node.val;
            }
            getMin(node.left);
            getMin(node.right);
        }
    }

    public class Mins {
        int first;
        int second;
        Mins(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
