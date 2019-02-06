package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoxAndNames_510C {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        Map<Character, List<Character>> newOrder = getNewWordOrdering(in, count);
        Map<Character, Character> original= generateOriginalOrder(newOrder);
        Map<Character, Integer> incoming = new HashMap<>();
        PriorityQueue<Character> queue = getQueue(newOrder, original, incoming);

        getFinalOrdering(newOrder, original, queue, incoming);
    }

    private static Map<Character, List<Character>> getNewWordOrdering(BufferedReader in, int count) throws IOException {
        Map<Character, List<Character>> newOrder = new HashMap<>();
        String currentString = in.readLine();
        for (int i = 0; i< count - 1; i++) {
            String nextString = in.readLine();

            for (int j = 0; j < Math.min(currentString.length(), nextString.length()); j++) {
                if (currentString.charAt(j) != nextString.charAt(j)) {
                    char start = currentString.charAt(j);
                    char end = nextString.charAt(j);
                    List<Character> adj = newOrder.getOrDefault(start, new ArrayList<>());
                    adj.add(end);
                    newOrder.put(start, adj);
                    break;
                }
            }
            currentString = nextString;
        }
        return newOrder;
    }

    private static void getFinalOrdering(
            Map<Character, List<Character>> updated,
            Map<Character, Character> original,
            PriorityQueue<Character> queue,
            Map<Character, Integer> incoming) {
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
                for (char adj: updated.getOrDefault(current, new ArrayList<>())) {
                    int currentIncoming = incoming.get(adj);
                    incoming.put(adj, currentIncoming--);
                    if (currentIncoming == 0 && !result.contains(adj))
                        queue.add(adj);
                }
            }
        }
        if (result.size() != 26) System.out.println("Impossible");
        else {
            for (char c: result)
                System.out.print(c);
            System.out.println();
        }
    }

    private static PriorityQueue<Character> getQueue(Map<Character, List<Character>> updated, Map<Character, Character> original, Map<Character, Integer> incoming) {
        PriorityQueue<Character> queue = new PriorityQueue<>();
        if (!original.isEmpty())
            queue.add(original.keySet().iterator().next());
        for (char c: updated.keySet()) {
            if (!incoming.containsKey(c))
                incoming.put(c, 0);
            for (char adj: updated.get(c)) {
                int current = incoming.getOrDefault(adj, 0);
                incoming.put(adj, current + 1);
            }
        }

        for (char c: incoming.keySet()) {
            if (incoming.get(c) == 0)
                queue.add(c);
        }
        return queue;
    }

    private static Map<Character, Character> generateOriginalOrder(Map<Character, List<Character>> updatedKeys) {
        Map<Character, Character> original = new HashMap<>();

        List<Character> originalLexico = new ArrayList<>();
        for (int i = 0; i< 26; i++)
            originalLexico.add((char)(i+97));

        originalLexico.removeAll(updatedKeys.keySet());
        for (List<Character> ch: updatedKeys.values())
            originalLexico.removeAll(ch);

        for (int startPos = 0; startPos < originalLexico.size() - 1; startPos++) {
            char start = originalLexico.get(startPos);
            char end = originalLexico.get(startPos + 1);
            original.put(start, end);
        }
        return original;
    }
}
