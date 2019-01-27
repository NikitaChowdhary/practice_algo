package leetCode;

import java.util.*;

public class CourseSchedule_207_BFS {

    class Result{
        boolean res = true;
    }

    private Result r = new Result();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();

        for (int[] pre: prerequisites) {
            List<Integer> adjacent = graph.getOrDefault(pre[0], new LinkedList<>());
            adjacent.add(pre[1]);
            graph.put(pre[0], adjacent);
        }
        for (int i =0; i< numCourses; i++) {
            if (!visited.containsKey(i)) {
                bfs(i, graph, visited);
            }
        }

        return r.res;
    }

    private void bfs(int start, Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.put(start, start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int adj: graph.getOrDefault(current, new LinkedList<>())) {
                if (!visited.containsKey(adj)) {
                    queue.add(adj);
                } else if (visited.get(adj) == start) {
                    r.res = false;
                    return;
                }

            }
            visited.put(current, start);
        }
    }

    public static void main(String[] args) {
        int courses = 4;
        int[][] pre = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
//
//        int courses = 2;
//        int[][] pre = {{1,0}};

//        int courses = 2;
//        int[][] pre = {{1,0}, {0,1}};

        System.out.println(new CourseSchedule_207_BFS().canFinish(courses, pre));
    }
}
