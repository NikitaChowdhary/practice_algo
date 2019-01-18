package leetCode;

import java.util.LinkedList;
import java.util.List;

public class FreindCircle_547 {
    public int findCircleNum(int[][] M) {
        List<Integer> visitingOrder = new LinkedList<>();
        boolean[] visited = new boolean[M.length];

        for (int i =0; i< M.length; i++) {
            if (!visited[i])
                findOrder(visited, i, visitingOrder, M);
        }

        int[][] transposed = getTransposed(M);
        visited = new boolean[M.length];
        int count = 0;
        for (int i = visitingOrder.size() - 1; i>=0; i--) {
            if (!visited[i]) {
                findOrder(visited, i, new LinkedList<>(), transposed);
                count++;
            }

        }
        return count;

    }

    private int[][] getTransposed(int[][] m) {
        int[][] result = new int[m.length][m.length];
        for (int i = 0; i< m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                result[j][i] = m[i][j];
            }
        }
        return result;
    }

    private void findOrder(boolean[] visited, int start, List<Integer> visitingOrder, int[][] graph) {
        visited[start] = true;
        for (int i = 0; i < graph.length; i++) {
            int adj = graph[start][i];
            if (adj == 1 && !visited[i])
                findOrder(visited, i, visitingOrder, graph);
        }
        visitingOrder.add(start);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(new FreindCircle_547().findCircleNum(input));
    }
}
