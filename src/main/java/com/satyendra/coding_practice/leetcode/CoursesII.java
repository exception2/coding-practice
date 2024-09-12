package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CoursesII {
    public static void main(String[] args) {
        CoursesII coursesII = new CoursesII();
        int[] ans = coursesII.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for (int i = 0 ; i < ans.length ; i++) {
            System.out.println(ans[i]);
        }
        System.out.println();
        int[] ans1 = coursesII.findOrder(2,new int[][]{{0,1}, {1,0}});
        for (int i = 0 ; i < ans1.length ; i++) {
            System.out.println(ans1[i]);
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orders = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < prerequisites.length ; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj[u].add(v);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }
        if(isCycle(adj, numCourses)) return new int[0];
        int i = 0;
        while(!stack.isEmpty()) {
            orders[i++] = stack.pop();
        }
        return orders;
    }

    private void dfs(int u, List<Integer>[] adj, boolean[] vis, Stack<Integer> stack) {
        vis[u] = true;
        for(int i = 0 ; i < adj[u].size() ; i++) {
            if(!vis[adj[u].get(i)]) {
                dfs(adj[u].get(i), adj, vis, stack);
            }
        }
        stack.push(u);
    }

    private boolean isCycle(List<Integer>[] adj, int n) {
        boolean[] vis = new boolean[n];
        boolean[] recStack = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            if(!vis[i] && isCycleUtil(adj, i, vis, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(List<Integer>[] adj, int u, boolean[] vis, boolean[] recStack) {
        if(!vis[u]) {
            vis[u] = true;
            recStack[u] = true;
            for( int i = 0 ; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if(!vis[v] && isCycleUtil(adj, v, vis, recStack)) {
                    return true;
                } else if(recStack[v]) {
                    return true;
                }
            }
        }
        vis[u] = false;
        recStack[u] = false;
        return false;
    }
}
