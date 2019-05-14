package leetCode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Worst case O(n) as the number can be [1,1,1,1,1]
 *
 * Avg case O(log n)
 *
 */
public class FirstAndLast {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) return result;
        int a = binarySearch(0, nums.length - 1, nums, target);

        int start = a, end = a;
        while(true) {
            if (start >= 1 && nums[start - 1] == target)
                start--;
            else break;
        }

        while(true) {
            if (end < nums.length -1 && nums[end + 1] == target)
                end++;
            else break;
        }
        return new int[]{start, end};
    }

    private static int binarySearch(int i, int j, int[] nums, int target) {
        if (i > j) return -1;
        int mid = (i + j) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearch(i, mid - 1, nums, target);
        else return binarySearch(mid + 1, j, nums, target);
    }

    public static void main(String[] args) {
        int[] res = searchRange(new int[]{2, 2}, 3);

    }
}
