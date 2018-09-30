package GFGeek;

public class MaxPathSumBinaryTree {

    public int getMaxSum(TreeNode root, Res result) {
        if (root == null)
            return 0;

        int left = getMaxSum(root.left, result);
        int right = getMaxSum(root.right, result);

        int maxStartingWithRoot = Math.max(Math.max(left, right) + root.val, root.val);

        int maxThroughRoot = Math.max(left + right + root.val, maxStartingWithRoot);

        result.val = Math.max(maxThroughRoot, result.val);

        return maxStartingWithRoot;

    }

    public static class Res {
        int val;
        public Res(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MaxPathSumBinaryTree solution = new MaxPathSumBinaryTree();
        TreeNode tree = createTree();
        Res res = new Res(Integer.MIN_VALUE);
        System.out.print(solution.getMaxSum(tree,res));
    }

    private static TreeNode createTree() {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(10);
        tree.left.left = new TreeNode(20);
        tree.left.right = new TreeNode(1);
        tree.right.right = new TreeNode(-25);
        tree.right.right.left = new TreeNode(3);
        tree.right.right.right = new TreeNode(4);
        return tree;
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}