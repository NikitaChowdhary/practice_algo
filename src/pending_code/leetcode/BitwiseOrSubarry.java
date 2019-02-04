package pending_code.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BitwiseOrSubarry {


    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> currenOrs = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        currenOrs.add(0);

        for (int a: A) {
            Set<Integer> slidingWindowOr = new HashSet<>();
            for (int b: currenOrs) {
                slidingWindowOr.add(a|b);
            }
            slidingWindowOr.add(a);
            currenOrs = slidingWindowOr;
            result.addAll(slidingWindowOr);
        }
        return result.size();
    }

    // *********************************************************************************************************
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            int ret = new BitwiseOrSubarry().subarrayBitwiseORs(A);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
