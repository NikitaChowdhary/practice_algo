package leetCode;

// https://leetcode.com/problems/counting-bits/description/
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            if (i < 2)
                res[i] = i;
            else {
                int isPowerOfTwo = i & (i - 1);
                if (isPowerOfTwo == 0)
                    res[i] = 1;
                else if (i % 2 == 0)
                    res[i] = res[i / 2];
                else
                    res[i] = res[i - 1] + 1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new CountBits().countBits(5);
        for (int i: res){
            System.out.println(i);
        }
    }

}
