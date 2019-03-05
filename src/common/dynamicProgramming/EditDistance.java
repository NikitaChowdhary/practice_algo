package common.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();

        System.out.println(getEditDistance(a, b ,a.length(), b.length()));
    }

    private static int getEditDistance(String a, String b, int pos_a, int pos_b) {
        if (pos_a == 0 || pos_b == 0) return pos_a + pos_b;


        if (a.charAt(pos_a - 1) == b.charAt(pos_b - 1)) return getEditDistance(a, b, pos_a - 1, pos_b - 1);
        else {
            return 1 + Math.min(
                    Math.min(
                    getEditDistance(a, b, pos_a - 1, pos_b - 1),
                    getEditDistance(a, b, pos_a - 1, pos_b)
                    ),
                    getEditDistance(a, b, pos_a, pos_b - 1));
        }
    }

}
