package wayfair;

import java.util.*;

class BinPacking {

    public static void main(String[] args) {
        List<Integer> tasks = new ArrayList<>(List.of(7,2,3,9));
        List<Integer> types = new ArrayList<>(List.of(1,2,1,3));
        int max_memory=10;
        System.out.println("TOTAL_TIME:" + minTimeToFinishTasks(tasks, types, max_memory));

    }

    private static int minTimeToFinishTasks(List<Integer> tasks, List<Integer> types, int maxMemory) {
        int n = tasks.size();
        Map<Integer, List<Integer>> typesToTasks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            typesToTasks.putIfAbsent(types.get(i), new ArrayList<>());
            typesToTasks.get(types.get(i)).add(tasks.get(i));
        }
        int ans = 0;
        for (List<Integer> list : typesToTasks.values()) {
            Collections.sort(list);
            if (list.size() == 1) {
                ans++;
            } else {
                ans += findMinTime(list, maxMemory);
            }
        }
        return ans;
    }

    private static int findMinTime(List<Integer> list, int maxMemory) {
        int count = 0;
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) + list.get(r) <= maxMemory) {
                l++;
                r--;
            } else {
                r--;
            }
            count++;
        }
        return count;
    }
}
