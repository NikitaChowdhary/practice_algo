package pending_code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sum3 {
    
    private List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length == 3) {
            int sum = 0;
            for (int i: nums) sum+= i;

            if (sum ==0) {
                List<Integer> res = new LinkedList<>();
                for (int i: nums){
                    res.add(i);
                }
                result.add(res);
            }
        }
        else {
            Map<Integer, Integer> input = new HashMap<>();
            for (int i =0; i< nums.length; i++) input.put(nums[i], i);

            for (int n: nums) {
                result.addAll(findTwoNumbers(nums, input, n));
            }
        }
        return new ArrayList<>(result);
    }


    private Set<List<Integer>> findTwoNumbers(int[] nums, Map<Integer, Integer> mapOfItem, int k) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            int find = -1 *(nums[i] + k);
            if (mapOfItem.containsKey(find)
                    && (i != mapOfItem.get(k))
                    && (i != mapOfItem.get(find))
                    && (!mapOfItem.get(k).equals(mapOfItem.get(find)))
            ) {
                List<Integer> res = new LinkedList<>();
                res.add(k);
                res.add(nums[i]);
                res.add(find);
                Collections.sort(res);
                result.add(res);
            }
        }
        return result;
    }

    //////////////////////////////////////





    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Sum3().threeSum(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
