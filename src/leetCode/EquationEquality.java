package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class EquationEquality {
    public boolean equationsPossible(String[] equations) {
        int[] numbers = new int[26];

        for (int i = 0; i< 26; i++) numbers[i] = i + 1;

        Map<Integer, List<Integer>> graph = generateGraph(equations);

        for (int start: graph.keySet()) {
            for (int adj: graph.get(start)) {
                numbers[adj] = numbers[start];
            }
        }

        boolean result = true;
        for (String equation: equations) {
            if (equation.charAt(1) == '!') {
               result = result &  numbers[equation.charAt(0) - 97] != numbers[equation.charAt(3) - 97];
            }
        }
        return result;

    }

    private Map<Integer, List<Integer>> generateGraph(String[] equations) {
        Map<Integer, List<Integer>> equals = new HashMap<>();

        for (String equation: equations) {
            if (equation.charAt(1) == '=')
                addToGraph(equals, equation.charAt(0), equation.charAt(3));
        }
        return equals;
    }

    private void addToGraph(Map<Integer, List<Integer>> graph, char start, char end) {
        int e1 = start - 97;
        int e2 = end - 97;
        List<Integer> adj = graph.getOrDefault(e1, new ArrayList<>());
        adj.add(e2);
        graph.put(e1, adj);

        adj = graph.getOrDefault(e2, new ArrayList<>());
        adj.add(e1);
        graph.put(e2, adj);
    }

    public static void main(String[] args) {
        
    }
}
