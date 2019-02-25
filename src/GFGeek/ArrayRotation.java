package GFGeek;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int rotateBy = -3;

        System.out.println("Current Array");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        int k = sanitizek(rotateBy, input.length);
        getRotatedArrayGCD(input, k);

        System.out.println("\nRotated array");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }

    private static int sanitizek(int rotateBy, int length) {
        int res = rotateBy % length;
        if (res < 0) res = length + res;
        return res;
    }

    /**
     * Cases to consider
     * rotation factor is greater than array size.
     * rotation factor is positive.
     * rotation factor is negative.
     *
     * @param input
     * @param rotateBy
     * @return
     */
    private static void getRotatedArray(int[] input, int rotateBy) {
        if (rotateBy == 0) return;
        else if (rotateBy > 0) {
            int i = 0;
            int current = input[i++];
            for (; i < input.length; i++)
                input[i - 1] = input[i];
            input[i - 1] = current;

            getRotatedArray(input, rotateBy - 1);
        } else {
            int i = input.length - 1;
            int current = input[i];
            for (; i > 0; i--)
                input[i] = input[i - 1];
            input[i] = current;

            getRotatedArray(input, rotateBy + 1);
        }

    }

    private static void getRotatedArrayGCD(int[] input, int rotateBy) {
        int n = input.length;
        int gcd = gcd(n, Math.abs(rotateBy));

        for (int i = 0; i< gcd; i++) {

            int current = input[i];
            int j = i;

            while(true) {
                int k = (j + rotateBy) % n;
                if (k == i) break;
                input[j] = input[k];
                j = k;
            }
            input[j] = current;
        }

    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }


}
