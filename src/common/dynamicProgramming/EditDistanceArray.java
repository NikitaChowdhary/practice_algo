package common.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistanceArray {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();

        System.out.println(getEditDistance(a, b ,a.length(), b.length()));
    }

    private static int getEditDistance(String a, String b, int lena, int lenb) {
        int[][] dp = new int[lena + 1][lenb + 1];

        for (int i = 0; i <=lena; i++) {
            for (int j = 0; j<=lenb; j++) {
                if ( i== 0 || j == 0) dp[i][j] = i + j;

                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
            }
        }
        return dp[lena][lenb];
    }
}
