package general;

import java.util.ArrayList;
import java.util.List;


public class DistanceInTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] answer = sumOfDistancesInTree(6, edges);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] result = new int[n];
        for(int i = 0 ;i < n; i++) {
            int[] visited = new int[n];
            int[] dp = new int[n];
            update(dp, graph, i, 0, visited);
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += dp[j];
            }
            result[i] = sum;
        }
        return result;
    }

    private static void update(int[] dp, List<List<Integer>> graph, int target, int dist, int[] visited) {
        visited[target] = 1;
        dp[target] = dist;
        for (int next : graph.get(target)) {
            if(visited[next] == 0) {
                update(dp, graph, next, dist + 1, visited);
            }
        }
    }
}
