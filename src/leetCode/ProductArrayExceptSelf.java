package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ProductArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        List<Integer> zeroPosition = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] != 0)
                product *= nums[i];
            else zeroPosition.add(i);
        }

        int[] result = new int[nums.length];
        if (zeroPosition.isEmpty()) {
            for (int i = 0; i < nums.length; i++)
                result[i] = product/nums[i];
        }
        else if (zeroPosition.size() == 1) {
            result[zeroPosition.get(0)] = product;
        }

        return result;
    }
}
