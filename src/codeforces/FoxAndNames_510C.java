package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FoxAndNames_510C {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(in.readLine());

        Map<Character, Character> newOrder = new HashMap<>();

        String currentString = in.readLine();
        for (int i = 0; i< count - 1; i++) {
            String nextString = in.readLine();
            getWordsOrder(currentString, nextString, newOrder);
            currentString = nextString;
        }

        System.out.println(getFinalOrdering(newOrder));
    }

    private static void getWordsOrder(String currentString, String nextString, Map<Character, Character> newOrder) {
        for (int j = 0; j < Math.min(currentString.length(), nextString.length()); j++) {
            if (currentString.charAt(j) != nextString.charAt(j)) {
                char start = currentString.charAt(j);
                char end = nextString.charAt(j);
                newOrder.put(start, end);
                break;
            }
        }
    }

    private static String getFinalOrdering(Map<Character, Character> updated) {
        String result = "";
        Set<Character> newOrdered = new HashSet<>();
        newOrdered.addAll(updated.keySet());
        newOrdered.addAll(updated.values());
        Map<Character, Character> original= generateOriginalOrder(newOrdered);

        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (char c: updated.keySet()) {
            if (!updated.values().contains(c))
                queue.add(c);
        }
        if (!original.isEmpty())
            queue.add(original.keySet().iterator().next());


        boolean[] visited = new boolean[26];
        while(!queue.isEmpty()) {
            char current = queue.poll();
            if (visited[current - 97]) {
                result = "Impossible";
                break;
            } else {
                result += current;
                if (original.containsKey(current))
                    queue.add(original.get(current));
                if (updated.containsKey(current))
                    queue.add(updated.get(current));
            }
            visited[current] = true;
        }

        if (result.length() != 26) result = "Impossible";
        return result;
    }

    private static Map<Character, Character> generateOriginalOrder(Set<Character> newOrdered) {
        Map<Character, Character> original = new HashMap<>();
        int i = 0;
        while(newOrdered.contains((char)(i+97)))
            i++;
        char start = (char)(i+97);
        while (i++ < 25) {
            while(newOrdered.contains((char)(i+97)))
                i++;
            if (i < 26) {
                char end = (char) (i + 97);
                original.put(start, end);
                start = end;
            }
        }
        return original;
    }
}
