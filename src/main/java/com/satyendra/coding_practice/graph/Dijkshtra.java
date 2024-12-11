package com.satyendra.coding_practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkshtra {
    public static void main(String[] args) {
        int V = 7;
        List<List<List<Integer>>> adj = new ArrayList<>();
        adj.add(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 6)));
        adj.add(Arrays.asList(Arrays.asList(0, 2), Arrays.asList(3, 5)));
        adj.add(Arrays.asList(Arrays.asList(0, 6), Arrays.asList(3, 8)));
        adj.add(Arrays.asList(Arrays.asList(2, 8), Arrays.asList(1, 5), Arrays.asList(4, 10), Arrays.asList(5, 15)));
        adj.add(Arrays.asList(Arrays.asList(3, 10), Arrays.asList(6, 2)));
        adj.add(Arrays.asList(Arrays.asList(3, 15), Arrays.asList(6, 6)));
        adj.add(Arrays.asList(Arrays.asList(4, 2), Arrays.asList(5, 6)));
        int[] res = dijkstra(V, adj, 0);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S)
    {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] res = new int[V];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[S] = 0;
        pq.add(new int[]{S, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] = true;
            for (int i = 0; i < adj.get(curr[0]).size(); i++) {
                int[] next = adj.get(curr[0]).get(i).stream().mapToInt(Integer::intValue).toArray();
                if (res[next[0]] > res[curr[0]] + next[1]) {
                    res[next[0]] = res[curr[0]] + next[1];
                    pq.add(new int[]{next[0], res[next[0]]});
                }
            }
        }
        return res;
    }
}
