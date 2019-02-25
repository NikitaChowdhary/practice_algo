package GFGeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rotate2D {

    // https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space/0
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());

        while(cases-- != 0) {
            int n = Integer.parseInt(in.readLine());
            String[] array = in.readLine().split(" ");

            getUpdated(array, n);

            for (String s: array)
                System.out.print(s + " ");
            System.out.println();
        }
    }

    private static void getUpdated(String[] array, int n) {

        for (int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) < n) {
                    int current = i * n + j;
                    int updated = (n - 1 - j) * n + (n - 1 - i);

                    String currentStr = array[current];
                    array[current] = array[updated];
                    array[updated] = currentStr;
                }
            }
        }

        for (int i = 0; i< n/2; i++) {
            for (int j = 0; j< n; j++) {
                int current = i * n + j;
                int updated = (n - 1 - i) * n + j;

                String currentStr = array[current];
                array[current] = array[updated];
                array[updated] = currentStr;
            }
        }
    }
}
