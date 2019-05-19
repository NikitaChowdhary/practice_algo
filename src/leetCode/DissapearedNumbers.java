package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class DissapearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i< nums.length; i++) {
            int position = Math.abs(nums[i]) - 1;
            if (nums[position] > 0)
                nums[position] = - nums[position];
        }

        for (int i = 0; i< nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        for (int i : findDisappearedNumbers(input))
            System.out.println(i);
    }
}
