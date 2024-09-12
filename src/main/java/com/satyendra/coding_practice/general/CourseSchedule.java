package general;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        //System.out.println(!canFinish(2, new int[][]{{1, 0}}));
        //System.out.println(!canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        //System.out.println(!canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 0}}));
        System.out.println(canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(isCycleDetected(graph, visited, recStack, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCycleDetected(List<List<Integer>> graph, boolean[] visited, boolean[] recStack, int i) {
        if(recStack[i]) {
            return true;
        }
        if(visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;
        for(int next : graph.get(i)) {
            if(isCycleDetected(graph, visited, recStack, next)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }
}
