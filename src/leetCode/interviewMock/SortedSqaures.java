package leetCode.interviewMock;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class SortedSqaures {

    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];

        int positivePos = A.length;
        int negativePos = -1;
        for (int i = 0; i< A.length; i++) {
            if (A[i] < 0)negativePos = i;
            else {
                positivePos = i;
                break;
            };
        }
        int i = 0;
        for (; i< A.length && positivePos < A.length && negativePos >=0; i++) {
            if (A[positivePos] * A[positivePos] < A[negativePos] * A[negativePos]) {
                res[i] = A[positivePos] * A[positivePos];
                positivePos++;
            } else {
                res[i] = A[negativePos] * A[negativePos];
                negativePos--;
            }
        }

        if (negativePos >= 0) {
            while(negativePos >=0) {
                res[i++] = A[negativePos] * A[negativePos];
                negativePos--;
            }
        }

        if (positivePos < A.length) {
            while(positivePos < A.length) {
                res[i++] = A[positivePos] * A[positivePos];
                positivePos++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] inp = {-1};
        for (int i : sortedSquares(inp))
            System.out.println(i);
    }
}
