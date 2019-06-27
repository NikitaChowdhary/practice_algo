package common.dynamicProgramming;

public class MaxSum1DPrefixArray {

    int getMaxSum(int[] nums) {
        int[] prefixSum = new int[nums.length];

        if (nums.length == 0) return 0;
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int minPrefix = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i< nums.length; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefix);
            minPrefix = Math.min(minPrefix, prefixSum[i]);
        }
        return maxSum;
    }
}
