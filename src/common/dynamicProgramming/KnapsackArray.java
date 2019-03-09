package common.dynamicProgramming;

public class KnapsackArray {

    static int[] weight = {50, 20, 30};
    static int[] val = {60, 100, 120};


    public static void main(String[] args) {
        int targetWeight = 50;

        System.out.println(getMaxVal(targetWeight));
    }

    private static int getMaxVal(int targetWeight) {
        int[][] dp = new int[weight.length + 1][targetWeight + 1];

        for (int i = 0; i<= weight.length; i++) {
            for (int j = 0; j<= targetWeight; j++) {
                if (i==0 || j == 0)
                    dp[i][j] = 0;
                else if (weight[i - 1] <= j)
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - weight[i-1]], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[weight.length][targetWeight];
    }
}
