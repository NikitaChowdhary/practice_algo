package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * Time complexity - O(n)
 * Space complexity O(1)
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int startPos = 0;
        while(startPos < nums.length) {
            int finalPosition = startPos + 1;
            while(finalPosition < nums.length && nums[finalPosition] - nums[startPos] == finalPosition - startPos)
                finalPosition++;
            if (finalPosition != startPos + 1) {
                result.add(nums[startPos] + "->" + nums[finalPosition - 1]);
            } else {
                result.add(nums[startPos] + "");
            }
            startPos = finalPosition;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        int[] nums1 = {0, 9, 10};
        for (String a : summaryRanges(nums1)) {
            System.out.println(a);
        }
    }
}
