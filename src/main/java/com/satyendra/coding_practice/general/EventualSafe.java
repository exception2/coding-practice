package general;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class EventualSafe {

    public static void main(String[] args) {
        EventualSafe ev = new EventualSafe();
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(ev.eventualSafeNodes(graph1));
        int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(ev.eventualSafeNodes(graph2));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> set = IntStream.range(0, n).boxed().collect(Collectors.toSet());
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                dfs(i, vis, graph, set);
            }
        }

        List<Integer> evsList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(!set.contains(i)) {
                evsList.add(i);
            }
        }
        return evsList;
    }

    private void dfs(int i, boolean[] vis, int[][] graph, Set<Integer> set) {
        if(vis[i]) {
            return;
        }
        vis[i] = true;
        if(graph[i].length==0) {
            set.remove(i);
        } else {
            for(int j = 0;j<graph[i].length;j++) {
                dfs(graph[i][j], vis, graph, set);
            }
            boolean eventualSafe = true;
            for(int j = 0;j<graph[i].length;j++) {
                if(set.contains(graph[i][j])) {
                    eventualSafe = false;
                }
            }
            if(eventualSafe) {
                set.remove(i);
            }
        }
    }
}
