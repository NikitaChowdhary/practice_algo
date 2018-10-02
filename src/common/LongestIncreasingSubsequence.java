package common;

import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public int getLIS(List<Integer> input) {
        if (input.isEmpty())
            return 0;
        else {
            Length result = new Length(0);
            computeLIS(input, 0, 0, result);
            return result.val;
        }
    }

    private void computeLIS(List<Integer> input, int start, int current, Length result) {
        if (current < input.size() - 1 && input.get(current) < input.get(current + 1)) {
            computeLIS(input, start, current + 1, result);
        } else if (current < input.size()){
            int currentMax = current - start + 1;
            if (result.val < currentMax)
                result.val = currentMax;
            computeLIS(input, current + 1, current + 1, result);
        }
    }


    public static void main(String[] args) {
        List<Integer> input = new LinkedList<>();
        input.add(20);
        input.add(15);
        input.add(11);
        input.add(9);
        input.add(7);
        input.add(6);
        input.add(5);
        input.add(4);
        System.out.println(new LongestIncreasingSubsequence().getLIS(input));

    }

    public class Length {
        int val;
        public Length(int val) {
            this.val = val;
        }
    }
}
