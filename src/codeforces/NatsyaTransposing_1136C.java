package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NatsyaTransposing_1136C {


    // https://codeforces.com/contest/1136/problem/C

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] index = in.readLine().split(" ");
        int rows = Integer.parseInt(index[0]);
        int cols = Integer.parseInt(index[1]);

        String[][] original = new String[rows][cols];
        String[][] transposed = new String[rows][cols];

        for (int i = 0; i< rows; i++) {
            original[i] = in.readLine().split(" ");
        }

        for (int i = 0; i< rows; i++) {
            transposed[i] = in.readLine().split(" ");
        }

        if(isPossible(original, transposed, rows, cols))
            System.out.println("YES");
        else System.out.println("NO");



    }

    private static boolean isPossible(String[][] original, String[][] transposed, int rows, int cols) {
        boolean isPossible = true;

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< cols; j++) {
                if (!original[i][j].equals(transposed[i][j]) && !original[i][j].equals(transposed[j][i])) {
                    isPossible = false;
                }
            }
        }
        return isPossible;
    }

}
