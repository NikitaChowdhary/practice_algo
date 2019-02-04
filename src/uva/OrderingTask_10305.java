/*
 * Date - 4th February, 2019
 */
package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class OrderingTask_10305 {

    // https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1246

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String inp = in.readLine();
            if (inp.equals("0 0")) break;
            else {
                String[] inputs = inp.split(" ");
                int tasks = Integer.parseInt(inputs[0]);
                int edges = Integer.parseInt(inputs[1]);

                Map<Integer, List<Integer>> dependency = new HashMap<>();
                int[] incoming = new int[tasks + 1];
                for (int i = 0; i< edges; i++) {
                    String[] temp = in.readLine().split(" ");
                    int start = Integer.parseInt(temp[0]);
                    int end = Integer.parseInt(temp[1]);

                    List<Integer> adjacent = dependency.getOrDefault(start, new ArrayList<>());
                    adjacent.add(end);
                    dependency.put(start, adjacent);
                    incoming[end]++;
                }

                Queue<Integer> queue = getQueue(incoming);
                List<Integer> task_order = new ArrayList<>();

                getOrder(dependency, queue, incoming, task_order, tasks);
                for (int x: task_order)
                    System.out.print(x + " ");
                System.out.println();

            }
        }



    }

    private static void getOrder(Map<Integer, List<Integer>> dependency, Queue<Integer> queue, int[] incoming, List<Integer> task_order, int tasks) {
        boolean[] visited = new boolean[tasks + 1];
        while(!queue.isEmpty()) {
            int current = queue.poll();
            task_order.add(current);
            for (int adj: dependency.getOrDefault(current, new ArrayList<>())) {
                if (!visited[adj]) {
                    incoming[adj]--;
                    if (incoming[adj] == 0)
                        queue.add(adj);
                }
            }
            visited[current] = true;
        }
    }

    private static Queue<Integer> getQueue(int[] incoming) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i< incoming.length; i++) {
            if (incoming[i] == 0)
                queue.add(i);
        }
        return queue;
    }
}
