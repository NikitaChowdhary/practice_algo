package leetCode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * O(log n)
 */
public class FirstAndLast_Optimized {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int leftIndex = getIndex(nums, target, true);
        if (leftIndex >= nums.length || nums[leftIndex] != target) return result;
        result[0] = leftIndex;
        result[1] = getIndex(nums, target, false);
        return result;
    }

    private static int getIndex(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || left && nums[mid] == target)
                high = mid;
            else low = mid + 1;

        }
        return low;
    }

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{2, 3, 3, 3, 3, 3, 4}, 3);

    }
}
