package leetCode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/contest/weekly-contest-112/problems/minimum-increment-to-make-array-unique/
// Max number = 40000
public class MinIncrement {

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
            return count;
        }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,2, 9, 9, 9, 10, 11, 11, 11, 11};
        int[] input2 = new int[] {1, 2, 2};
        System.out.println(new MinIncrement().minIncrementForUnique(input));
    }
}
