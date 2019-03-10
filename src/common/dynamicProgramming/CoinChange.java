package common.dynamicProgramming;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        System.out.println(getCount(coins, amount, 0));
    }

    private static int getCount(int[] coins, int amount, int currentIndex) {
        if (amount == 0) return 1;
        else if (currentIndex == coins.length) return 0;

        else if (amount >= coins[currentIndex])
            return getCount(coins, amount - coins[currentIndex], currentIndex) +
                getCount(coins, amount, currentIndex + 1);
        else return getCount(coins, amount, currentIndex + 1);
    }
}
