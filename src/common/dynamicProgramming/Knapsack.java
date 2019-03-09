package common.dynamicProgramming;

public class Knapsack {

    static int[] weight = {50, 20, 30};
    static int[] val = {60, 100, 120};


    public static void main(String[] args) {
        int targetWeight = 50;

        System.out.println(getMaxVal1(targetWeight, 0));
    }

    private static int getMaxVal1(int currentWeight, int index) {
        if (currentWeight == 0 || index == weight.length) return 0;
        if (weight[index] > currentWeight)
            return getMaxVal1(currentWeight, index + 1);
        else
            return Math.max(
                    val[index] + getMaxVal1(currentWeight - weight[index], index + 1),
                    getMaxVal1(currentWeight, index + 1));

    }
}

