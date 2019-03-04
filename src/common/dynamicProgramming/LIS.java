package common.dynamicProgramming;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
 * subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {
    // TLE
    private static int lis_length = 1;
    public static void main(String[] args) {
        int[] input = new int[10];
        //{4,10,4,3,8,9};
//        int[] input2 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
//        int[] input3 = {10, 20, 7, 8, 30, 9, 40};
//        int[] input4 = {1,3,6,7,9,4,10,5,6};

        if (input.length == 0) System.out.println(0);
        else {
            getLIS(input, 0);
            System.out.println(lis_length);
        }

    }


    private static int getLIS(int[] input, int start) {
        if (start == input.length - 1) return 1;

        else {
            int currentMax = 1;
            for (int i = start + 1; i < input.length; i++) {
                int current_lis = getLIS(input, i);

                if (input[start] < input[i] && current_lis + 1 > currentMax)
                    currentMax = current_lis + 1;
            }
            if (lis_length < currentMax) lis_length = currentMax;
            return currentMax;
        }

    }
}
