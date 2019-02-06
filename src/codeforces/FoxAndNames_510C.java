package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoxAndNames_510C {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        Map<Character, Character> newOrder = getNewWordOrdering(in, count);
        Map<Character, Character> original= generateOriginalOrder(newOrder);
        PriorityQueue<Character> queue = getQueue(newOrder, original);

        getFinalOrdering(newOrder, original, queue);
    }

    private static Map<Character, Character> getNewWordOrdering(BufferedReader in, int count) throws IOException {
        Map<Character, Character> newOrder = new HashMap<>();
        String currentString = in.readLine();
        for (int i = 0; i< count - 1; i++) {
            String nextString = in.readLine();

            for (int j = 0; j < Math.min(currentString.length(), nextString.length()); j++) {
                if (currentString.charAt(j) != nextString.charAt(j)) {
                    char start = currentString.charAt(j);
                    char end = nextString.charAt(j);
                    newOrder.put(start, end);
                    break;
                }
            }
            currentString = nextString;
        }
        return newOrder;
    }

    private static void getFinalOrdering(Map<Character, Character> updated, Map<Character, Character> original, PriorityQueue<Character> queue) {
        List<Character> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            char current = queue.poll();
            if (result.contains(current)) {
                break;
            }
            else {
                result.add(current);
                if (original.containsKey(current))
                    queue.add(original.get(current));
                if (updated.containsKey(current))
                    queue.add(updated.get(current));
            }
        }
        if (result.size() != 26) System.out.println("Impossible");
        else {
            for (char c: result)
                System.out.print(c);
            System.out.println();
        }
    }

    private static PriorityQueue<Character> getQueue(Map<Character, Character> updated, Map<Character, Character> original) {
        PriorityQueue<Character> queue = new PriorityQueue<>();
        if (!original.isEmpty())
            queue.add(original.keySet().iterator().next());
        for (char c: updated.keySet()) {
            // Add all which has 0 incoming egde, as there can be only one incoming edge to a node.
            if (!updated.values().contains(c))
                queue.add(c);
        }
        return queue;
    }

    private static Map<Character, Character> generateOriginalOrder(Map<Character, Character> updatedKeys) {
        Map<Character, Character> original = new HashMap<>();

        List<Character> originalLexico = new ArrayList<>();
        for (int i = 0; i< 26; i++)
            originalLexico.add((char)(i+97));

        originalLexico.removeAll(updatedKeys.keySet());
        originalLexico.removeAll(updatedKeys.values());

        for (int startPos = 0; startPos < originalLexico.size() - 1; startPos++) {
            char start = originalLexico.get(startPos);
            char end = originalLexico.get(startPos + 1);
            original.put(start, end);
        }
        return original;
    }
}
