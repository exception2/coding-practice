package com.satyendra.coding_practice.wayfair;

import java.util.*;

public class PodsNetwork {
    public static void main(String[] args) {
        int pods = 3;
        List<List<Integer>> connections = List.of(List.of(1, 2), List.of(2, 3));
        List<List<Integer>> queries = List.of(List.of(2, 2), List.of(1, 2), List.of(2, 1), List.of(2, 3), List.of(1, 1));
        List<Integer> list = recoverDeadPods(pods, connections, queries);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> recoverDeadPods(int pods, List<List<Integer>> connections, List<List<Integer>> queries) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = connections.size();
        for (int i =0;i<=pods;i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> regionIdMap = new HashMap<>();
        int[] regionId = new int[pods+1];
        boolean[] visited = new boolean[pods+1];
        visited[0] = true;
        int region = 1;
        for (int i = 1; i <= pods; i++) {
            List<Integer> list = new ArrayList<>();
            if (!visited[i]) {
                dfs(graph, i, visited, list);
                if(!list.isEmpty()) {
                    regionIdMap.put(region, list);
                    for(Integer node : list) {
                        regionId[node] = region;
                    }
                    region++;
                }
            }
        }
        for (List<Integer> query : queries) {
            int q = query.get(0);
            int podId = query.get(1);
            int regionId1 = regionId[podId];
            List<Integer> list = regionIdMap.get(regionId1);
            if (q == 1) {
                if(list.isEmpty()) {
                    ans.add(-1);
                } else if(list.contains(podId)) {
                    ans.add(podId);
                } else {
                    Collections.sort(list);
                    ans.add(list.get(0));
                }
            } else {
                if(list.contains(podId)) {
                    list.remove(Integer.valueOf(podId));
                    regionIdMap.put(regionId1, list);
                }
            }
        }
        return ans;
    }

    private static void dfs(List<List<Integer>> graph, int i, boolean[] visited, List<Integer> list) {
        visited[i] = true;
        list.add(i);
        for (int next : graph.get(i)) {
            if (!visited[next]) {
                dfs(graph, next, visited, list);
            }
        }
    }
}