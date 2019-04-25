package careercup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://www.careercup.com/question?id=5732335291465728
 *
 * Generate random max index
 *
 * Given an array of integers, randomly return an index of the maximum value seen by far.
 *
 * e.g.
 * Given [11,30,2,30,30,30,6,2,62, 62]
 *
 * Having iterated up to the at element index 5 (where the last 30 is),
 * randomly give an index among [1, 3, 4, 5] which are indices of 30 - the max value by far. Each index should have a ¼ chance to get picked.
 *
 * Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.
 *
 * Time Complexity -> O(2*n) -> O(n)
 * Space Complexity -> O(1)
 */

public class RandomMaxIndex {

    public static void main(String[] args) {
        int[] input = {11,30,2,30,30,30,6,2,62, 62};

        int max = Integer.MIN_VALUE;

        for (int a: input) {
            if (a > max)
                max = a;
        }

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i< input.length; i++) {
            if (input[i] == max)
                indexes.add(i);
        }

        System.out.println("Random max integer index: " + indexes.get(new Random().nextInt(indexes.size())));


    }
}
