package pending_code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        else if (m == n) return m;
        else {
            int temp = n;
            int result = 1;
            while(temp >= 2) {
                result *= 2;
                temp /= 2;
            }
            return result & m & n;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new BitwiseAnd().rangeBitwiseAnd(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
