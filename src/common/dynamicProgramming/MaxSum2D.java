package common.dynamicProgramming;

public class MaxSum2D {


    static int rows = 4;
    static int cols = 5;
    public static void main(String[] args) {
        int[][] input = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        System.out.println(getMax2D(input));

    }

    private static int getMax2D(int[][] input) {
        if (input.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int top = 0, bottom = 0;

        for (int topRow = 0; topRow < rows; topRow++) {
            int[] temp = new int[cols];
            for (int bottomRow = topRow; bottomRow < rows; bottomRow++) {
                for (int i = 0; i < cols; i++)
                    temp[i] += input[bottomRow][i];

                int currentMax = getMax1D(temp);
                if (currentMax > maxSum) {
                    maxSum = currentMax;
                    top = topRow;
                    bottom = bottomRow;
                }
            }
        }
        System.out.println(top);
        System.out.println(bottom);
        return maxSum;

    }

    private static int getMax1D(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for (int i: input) {
            sumSoFar = Math.max(i, sumSoFar + i);
            maxSum = Math.max(maxSum, sumSoFar);
        }
        return maxSum;
    }
}
