package leetCode;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubArraySumDivK {
    public int subarraysDivByK(int[] A, int K) {

        int[] mod = new int[K];

        int sum = 0;
        for (int i = 0; i< A.length; i++) {
            sum += A[i];
            mod[((sum % K) + K ) % K]++;
        }

        int result = 0;
        for (int i = 0; i< K; i++) {
            if (mod[i] > 1)
                result += (mod[i] * mod[i] - 1) / 2;
        }

        result += mod[0];
        return result;
    }
}
