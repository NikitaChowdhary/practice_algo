package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseSchedule2_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] pre: prerequisites) {
            List<Integer> adjacent = graph.get(pre[0]);
            for (int i = 1; i< pre.length; i++) {
                adjacent.add(pre[i]);
            }
            graph.put(pre[0], adjacent);
        }

        int[] color = new int[numCourses]; // 0 is white, 1 is grey, 2 is black
        List<Integer> result = new LinkedList<>();
        int[] output = new int[numCourses];

        boolean possible = true;
        for (int i = 0; i< numCourses; i++) {
            if (color[i] == 0) {
                possible &= dfs(i, graph, color, result);
            }
        }
        if (!possible){
            output = new int[0];
        }
        else {
            int i =0;
            for (int x: result) {
                output[i] = x;
                i++;
            }
        }

        return output;
    }

    private boolean dfs(int start, Map<Integer, List<Integer>> graph, int[] visited,  List<Integer> result) {
        visited[start] = 1;

        for (int adj: graph.get(start)) {
            if (visited[adj] == 0) {
                dfs(adj , graph, visited, result);
            }
            if(visited[adj] == 1) return false;

        }
        visited[start] = 2;
        result.add(start);
        return true;
    }

    public static void main(String[] args) {
        int num = 4;
        int[][] pre = {{1,0}, {2,0}, {3,1}, {3,2}};
        int[][] pre1 = {{0,1}};
        int[] res = new CourseSchedule2_210().findOrder(2, pre1);
        for (int i: res) {
            System.out.print(i);
        }
    }
}
