package common.dynamicProgramming;

public class MaxSum1D {

    static int maxSum = 0;
    public static void main(String[] args) {
        int[] input = {-2, -3, -3};
        System.out.println(getMaxSum(input));
    }

    private static int getMaxSum(int[] nums) {
        if (nums.length == 0) return 0;
        else {
            int maxSum = Integer.MIN_VALUE;
            int sumSoFar = 0;
            int start = 0, finalStart = 0, finalEnd = 0;

            for (int i = 0; i< nums.length; i++) {
                sumSoFar = sumSoFar + nums[i];
                if (sumSoFar > maxSum){
                    maxSum = sumSoFar;
                    finalStart = start;
                    finalEnd = i;
                }

                if (sumSoFar < 0) {
                    sumSoFar = 0;
                    start = i + 1;
                }
            }
            System.out.println("Final array index is " + finalStart + " " + finalEnd);
            return maxSum;
        }
    }
}
