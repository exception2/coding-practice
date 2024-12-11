package com.satyendra.coding_practice.uber;

import java.util.*;

public class CoursesII {
    public static void main(String[] args) {
        CoursesII coursesII = new CoursesII();
        int courses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        int[] results = coursesII.findOrder(courses, prerequisites);
        for(int o : results){
            System.out.println(o);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v);
        }

        return topologicalSort(numCourses, adj);
    }

    private int[] topologicalSort(int n, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n];
        int[] arr = new int[n];
        for(int u = 0; u < n; u++) {
            if(!vis[u]) {
                if(topologicalSortUtil(u, adj, stack, vis, new HashSet<>())) {
                    return new int[0];
                }
            }
        }

        int j = 0;
        while (!stack.isEmpty()) {
            arr[j++]= stack.pop();
        }
        return arr;
    }

    private boolean topologicalSortUtil(int u, List<List<Integer>> adj, Stack<Integer> stack, boolean[] vis, Set<Integer> set) {
        if (!vis[u]) {
            vis[u] = true;
            set.add(u);
            for(int v : adj.get(u)) {
                if(!vis[v] && topologicalSortUtil(v, adj, stack, vis, set)) {
                    return true;
                }
                else if(set.contains(v)) {
                    return true;
                }
            }
            stack.push(u);
        }
        set.remove(Integer.valueOf(u));
        return false;
    }
}
