package common.dynamicProgramming;

public class CoinChangeArray {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
            System.out.println(count(coins, coins.length, amount));
    }

    private static int getCount(int[] coins, int amount) {

        if (amount == 0) return 1;

        else if (coins.length == 0) return 0;

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i<coins.length; i++) {
            for (int j= 0; j<amount + 1; j++) {

                if (j == 0) dp[i][j] = 1;
                else {
                    int x =  (j - coins[i] >=0) ? dp[i][j - coins[i]]: 0 ;
                    int y = (i >= 1) ? dp[i - 1][j]: 0;
                    dp[i][j] = x + y;
                }

            }
        }
        return dp[coins.length - 1][amount];
    }


        public static int count( int S[], int m, int n )
        {
            int table[]=new int[n+1];


            table[0] = 1;

            // Pick all coins one by one and update the table[] values
            // after the index greater than or equal to the value of the
            // picked coin
            for(int i=0; i<m; i++)
                for(int j=S[i]; j<=n; j++)
                    table[j] += table[j-S[i]];

            return table[n];
        }
}
