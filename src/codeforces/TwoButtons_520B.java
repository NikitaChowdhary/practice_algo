package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoButtons_520B {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        getCount(n, m);
        System.out.println(count);
    }

    private static void getCount(int n, int m) {
//        System.out.println(n + " " + m);
        if (n >= m) count = count + (n - m);
        else {
            count = count + 1;
            if (m % 2 == 0) getCount(n, m/2);
            else getCount(n, m + 1);
        }
    }
}
