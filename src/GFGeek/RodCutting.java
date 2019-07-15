package GFGeek;

public class RodCutting {

    public int cutRod(int[] price, int n) {
        if (n <=0) return 0;

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < price.length; i++) {
            maxVal = Math.max(maxVal, price[i] + cutRod(price, n - i -1));
        }
        return maxVal;
    }

    public int cutRodDP(int[] price, int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i<=n; i++) {

        }
        return 1;
    }
}
