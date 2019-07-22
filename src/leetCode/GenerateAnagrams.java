package leetCode;

import java.util.HashSet;
import java.util.Set;

public class GenerateAnagrams {
    public static void main(String[] args) {
        for (String res: getAnangrams("blah")) {
            System.out.println(res);
        }
    }

    private static Set<String> getAnangrams(String str) {
        Set<String> res = new HashSet<>();
        generate("", str, res);
        return res;
    }

    private static void generate(String ana, String str, Set<String> res) {
        int size = str.length();
        if (size == 0) {
            res.add(ana);
        }
        for (int i = 0; i < size; i++) {
            generate(ana + str.charAt(i), str.substring(0, i) + str.substring(i + 1, size), res);
        }
    }
}
