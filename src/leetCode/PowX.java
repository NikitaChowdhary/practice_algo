package leetCode;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowX {
    public static double myPow(double x, int n) {

        if (n == 0) return 1;
        long N = n;
        if (n < 0) {
            x = 1/x;
            N =  -N;
        }
        double result = x;
        double ans = 1;

        for (long i = N; i>=1; i=i/2) {
            if (i % 2 == 1)
                ans = ans * result;
            result = result * result;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }

}
