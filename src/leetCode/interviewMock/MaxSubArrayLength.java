package leetCode.interviewMock;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 */
public class MaxSubArrayLength {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] inp = {1, -1, 5, -2, 3};

        System.out.println(sol.maxSubArrayLen(inp, 3));
    }

    public static class Solution {

        /**
        public int maxSubArrayLen(int[] nums, int k) {
            int maxLength = 0;
            for (int i = 0; i< nums.length; i++) {
                int currentSum = 0;
                for (int j = i; j < nums.length; j++) {
                    currentSum += nums[j];
                    if (currentSum == k) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
            return maxLength;
        }
         **/

        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, maxLength = 0;
            map.put(0, -1);
            for (int i = 0; i< nums.length; i++) {
                sum += nums[i];

                if (map.containsKey(sum - k))
                    maxLength = Math.max(maxLength, i - map.get(sum - k));
                if (!map.containsKey(sum))
                    map.put(sum, i);
            }
            return maxLength;
        }
    }
}


