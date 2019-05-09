package leetCode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            addToResult(upper, lower, result);
        else {
            long previous = lower;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > previous && previous <= upper) { // Missing range
                    addToResult(nums[i] - 1, previous, result);
                }
                previous = nums[i];
                previous++;
            }
            if (nums[nums.length - 1] < upper && previous <= upper)
                addToResult(upper, previous, result);
        }
        return result;
    }

    private static void addToResult(int end, long start, List<String> result) {
        if (start != end)
            result.add(start + "->" + end);
        else result.add(start + "");
    }

    public static void main(String[] args) {
        int[] inp = {0,1,3,50,75};

        int[] inp1 = {1, 1, 1};


        for (String r: findMissingRanges(inp, 0, 99))
            System.out.println(r);
    }

}
