package leetCode;

import java.io.IOException;
import java.util.*;

public class Sum3 {

    // O(n2) and o(n) auxillary space
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> mapOfItems = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i< nums.length; i++)
            mapOfItems.put(nums[i], i);

        for (int i = 0; i< nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = (nums[i] + nums[j]) * -1;
                if (mapOfItems.containsKey(key) && mapOfItems.get(key) != i &&  mapOfItems.get(key) != j) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    Collections.sort(temp);
                    result.add(temp);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSumOp(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i< nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    right--;

                } else if (sum < 0)
                    left++;
                else right--;

            }
        }
        return new ArrayList<>(result);

    }

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = new Sum3().threeSumOp(input);

        for (List<Integer> r: ret) {
            for (int i: r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
