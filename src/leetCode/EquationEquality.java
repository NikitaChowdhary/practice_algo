package leetCode;

import java.util.*;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class EquationEquality {
    public static boolean equationsPossible(String[] equations) {
        Map<Integer, List<Integer>> graph = generateGraph(equations);

        int[] numbers = new int[26];
        int currentNumber = 0;
        for (int i = 0; i< 26; i++) {
            if (numbers[i] == 0) {
                currentNumber++;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                numbers[i] = currentNumber;

                while(!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int adj: graph.getOrDefault(current, new ArrayList<>())) {
                        if (numbers[adj] == 0) {
                            numbers[adj] = currentNumber;
                            queue.add(adj);
                        }
                    }
                }
            }
        }
        for (String equation: equations) {
            if (equation.charAt(1) == '!') {
                int start = equation.charAt(0) - 'a';
                int end = equation.charAt(3) - 'a';
                if (start == end || numbers[start] != 0 && numbers[start] == numbers[end]) return false;
            }
        }
        return true;

    }

    private static Map<Integer, List<Integer>> generateGraph(String[] equations) {
        Map<Integer, List<Integer>> equals = new HashMap<>();

        for (String equation: equations) {
            if (equation.charAt(1) == '=')
                addToGraph(equals, equation.charAt(0), equation.charAt(3));
        }
        return equals;
    }

    private static void addToGraph(Map<Integer, List<Integer>> graph, char start, char end) {
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
        String[] input = {"v!=l","i!=g","m==n","s==w","c!=f","h==l","e==q","r==s","q!=l","c!=m","m!=q","r!=x","x!=f","q!=x","w==u","b!=p","u==w","e!=v","y!=m","i!=f","r!=y","c!=l","b!=h","k==p","p!=c","t==v","j!=o","b!=x","p!=u","r!=w"};
        System.out.println(equationsPossible(input));
    }
}
