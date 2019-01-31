package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Metro_1055A {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = in.readLine().split(" ");
        int stations = Integer.parseInt(inputs[0]);
        int dest = Integer.parseInt(inputs[1]);

        Map<Integer, List<Integer>> trainMap = new HashMap<>();
        String outgoing = in.readLine().replace(" ", "");
        String incoming = in.readLine().replace(" ", "");

        setTrainMap(trainMap, outgoing, incoming);

        boolean[] visited = new boolean[stations + 1];
        dfs(1, trainMap, visited, dest);
        if (visited[dest]) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void dfs(int start, Map<Integer, List<Integer>> trainMap, boolean[] visited, int dest) {
        visited[start] = true;
//        if (start == dest) return "YES";
        for (int adj: trainMap.getOrDefault(start, new LinkedList<>())) {
            if (!visited[adj])
                dfs(adj, trainMap, visited, dest);
        }
//        return "NO";
    }

    private static void setTrainMap(Map<Integer, List<Integer>> trainMap, String outgoing, String incoming) {
        int start = outgoing.indexOf('1');
        int end = -1;
        for (int i = start + 1; i< outgoing.length(); i++) {
            if (outgoing.charAt(i) == '1') {
                end = i;
            }
            if (end != -1) {
                addtoMap(trainMap, start + 1, end + 1);
                start = end;
                end = -1;
            }
        }

        start = incoming.lastIndexOf('1');
        end = -1;
        for (int i = start - 1; i >=0; i--) {
            if (incoming.charAt(i) == '1') {
                end = i;
            }
            if (end != -1) {
                addtoMap(trainMap, start + 1, end + 1);
                start = end;
                end = -1;
            }

        }
    }

    private static void addtoMap(Map<Integer, List<Integer>> trainMap, int start, int end) {
        List<Integer> adj = trainMap.getOrDefault(start, new LinkedList<>());
        adj.add(end);
        trainMap.put(start, adj);
    }
}
