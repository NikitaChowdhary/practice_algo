package leetCode.interviewMock;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 */
public class MaxSubArrayLength {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inp = {0,0};

        System.out.println(sol.maxSubArrayLen(inp, 0));
    }

    public static class Solution {
        int maxLength = 0;
        public int maxSubArrayLen(int[] nums, int k) {
            int currentSum = 0;
            for (int i = 0; i< nums.length; i++) {
                getLengthsCount(nums, k, i, i, currentSum);
                currentSum = 0;
            }
            return maxLength;
        }

        private void getLengthsCount(int[] nums, int k, int start, int end, int currentSum) {
            if (start <= end && end < nums.length) {
                currentSum = currentSum + nums[end];
                if (currentSum == k)
                    maxLength = Math.max(maxLength, end - start + 1);
//                else
                    getLengthsCount(nums, k, start, end + 1, currentSum);
            }

        }
    }
}


