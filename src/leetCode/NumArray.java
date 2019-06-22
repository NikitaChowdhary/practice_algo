package leetCode;

// https://leetcode.com/problems/range-sum-query-mutable/
public class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        if (i < nums.length) {
            nums[i] = val;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        if (i < j && j < nums.length) {
            for (int x = i; x <= j; x++)
                sum += nums[x];
        }
        return sum;
    }

}
