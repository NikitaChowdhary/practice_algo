package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationOfPhone {

    static Map<Integer, List<String>> mapping = new HashMap<>();
    static List<String> combinations = new ArrayList<>();

    public static void setMapping() {
        mapping.put(2, Arrays.asList("a", "b", "c"));
        mapping.put(3, Arrays.asList("d", "e", "f"));
        mapping.put(4, Arrays.asList("g", "h", "i"));
        mapping.put(5, Arrays.asList("j", "k", "l"));
        mapping.put(6, Arrays.asList("m", "n", "o"));
        mapping.put(7, Arrays.asList("p", "q", "r", "s"));
        mapping.put(8, Arrays.asList("t", "u", "v"));
        mapping.put(9, Arrays.asList("w", "x", "y", "z"));

    }

    public static List<String> letterCombinations(String digits) {
        setMapping();
        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) return result;
         // Some code here
        
        generateCombinations(digits, 0, result);

        
        return combinations;
    }

    private static void generateCombinations(String digits, int i, List<String> result) {
        if (i == digits.length()) {
            combinations.addAll(result);
            return;
        }
        List<String>  temp = new ArrayList<>();
        List<String> values = mapping.get(digits.charAt(i) - '0');
        if (result.isEmpty()) temp.addAll(values);
        else {
            for (String val: values) {
                for (String r: result) {
                    temp.add(r + val);
                }
            }
        }
        generateCombinations(digits, i+1, temp);
    }

    public static void main(String[] args) {
     for (String s: letterCombinations("23")) {
         System.out.println(s);
     }
    }
}
