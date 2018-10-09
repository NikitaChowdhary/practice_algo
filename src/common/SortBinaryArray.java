package common;

public class SortBinaryArray {

    /*
    Other solution in O(n) can be count number of 1 and replace them in the array
     */

    public void sort(int[] input) {
        int zeroLatest = 0;
        int oneLatest = input.length - 1;

        while (zeroLatest < oneLatest) {
            while (input[zeroLatest] == 0 && zeroLatest < oneLatest) zeroLatest++;
            while (input[oneLatest] == 1 && zeroLatest < oneLatest) oneLatest--;

            if (zeroLatest < oneLatest) {
                input[zeroLatest] = 0;
                input[oneLatest] = 1;
                zeroLatest++;
                oneLatest--;
            }
        }

    }

    public static void main(String[] args) {
        int[] input = {1, 0, 0, 0, 1, 1, 0, 1, 0};
        new SortBinaryArray().sort(input);
        for (int a: input)
            System.out.print(a);
    }
}
