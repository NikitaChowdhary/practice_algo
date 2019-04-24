package leetCode;

public class NextPerm {
    // https://leetcode.com/problems/next-permutation/

    public void nextPermutation(int[] nums) {


        // Find first decreasing position
        int i = nums.length - 2;
        while(i >=0 && nums[i + 1] <= nums[i])
            i--;

        if (i >=0) {
            // Find next number greater than i
            int j = nums.length - 1;
            while(j>=0 && nums[j] <= nums[i])
                j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
