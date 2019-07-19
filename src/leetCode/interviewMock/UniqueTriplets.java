package leetCode.interviewMock;

import java.util.*;

/**
 * Given an array nums of n integers,
 * are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class UniqueTriplets {

    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i< nums.length - 1; i++ ) {
            int start = i + 1;
            int end = nums.length -1;
            int third = i;

            while(start < end) {
                int sum = nums[start] + nums[end] +  nums[third];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[third], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum < 0)
                    start++;
                else end--;
            }
        }

        return new ArrayList(result);
    }
}
