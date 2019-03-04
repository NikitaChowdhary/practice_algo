package common.dynamicProgramming;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
 * subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LISArray {

    public static void main(String[] args) {
        int[] input = {4,10,4,3,8,9};
        int[] input2 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] input3 = {10, 20, 7, 8, 30, 9, 40};
        int[] input4 = {1,3,6,7,9,4,10,5,6};

        System.out.println(getLIS(input2));

    }

    // dp is length of LIS starting i

    private static int getLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i< nums.length; i++)
            dp[i] = 1;

        int lis = 1;
        for (int i = nums.length - 2; i >=0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
                lis = Math.max(lis, dp[i]);
            }
        }
        return lis;
    }
}
