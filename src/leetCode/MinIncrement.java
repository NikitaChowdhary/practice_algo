package leetCode;


import java.util.*;

// https://leetcode.com/contest/weekly-contest-112/problems/minimum-increment-to-make-array-unique/
// Max number = 40000
public class MinIncrement {


    public int minIncrementForUnique(int[] A) {
        int count = 0;
        if (A.length == 0) return 0;
        Arrays.sort(A);
        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= prev) {
                int temp = A[i];
                A[i] = prev + 1;
                count += A[i] - temp;
            }
                prev = A[i];
        }
        return count;


    }

    /*

    public int minIncrementForUnique(int[] A) {
            Set<Integer> s = new HashSet<>();
            int count = 0;
            for (int i : A) {
                int n = i;
                if (s.contains(n)) {
                    while (s.contains(n)) {
                        n++;
                        count++;
                    }
                    s.add(n);
                } else
                    s.add(i);
            }
            for (int a: A)
                System.out.print(a + " ");
            System.out.println();
            for (int a: s)
                System.out.print(a + " ");
            System.out.println();
            return count;
        }
        */

    public static void main(String[] args) {
        int[] input = new int[] {1,2,2, 9, 9, 9, 10, 11, 11, 11, 11};
        int[] input2 = new int[] {1, 2, 2};
        System.out.println(new MinIncrement().minIncrementForUnique(input));
    }
}
