package leetCode;

import java.util.*;

// https://leetcode.com/problems/most-frequent-subtree-sum/
public class MostFreqSubTreeSum {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int currentMax = 0;
    Map<Integer, Integer> sums = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getSubTreeSum(root);
        for (int a: sums.keySet()) {
            if (sums.get(a) == currentMax)
                result.add(a);
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int a: result)
            res[i++] = a;
        return res;
    }

    private int getSubTreeSum(TreeNode root) {
        if (root == null) return 0;
        int left = getSubTreeSum(root.left);
        int right = getSubTreeSum(root.right);

        int currentSum = left + right + 1;
        int count = sums.getOrDefault(currentSum, 0) + 1;
        currentMax = Math.max(currentMax, count);
        sums.put(currentSum, count);
        return currentSum;
    }
}
